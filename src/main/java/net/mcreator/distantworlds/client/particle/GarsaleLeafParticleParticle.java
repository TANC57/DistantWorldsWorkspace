
package net.mcreator.distantworlds.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

@OnlyIn(Dist.CLIENT)
public class GarsaleLeafParticleParticle extends TextureSheetParticle {
	public static GarsaleLeafParticleParticleProvider provider(SpriteSet spriteSet) {
		return new GarsaleLeafParticleParticleProvider(spriteSet);
	}

	public static class GarsaleLeafParticleParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public GarsaleLeafParticleParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new GarsaleLeafParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;
	private float angularVelocity;
	private float angularAcceleration;
	// Defining additional variables
	private float randSize = 0.25f;
	private float initialDirection;
	private int bounces;
	private float currentBoost;
	private float midLifeFactor;
	private float accelerationBoost;
	private int interval;
	private int onGroundTick;

	protected GarsaleLeafParticleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.gravity = 0.15f;
		this.hasPhysics = true;
		this.xd = vx * 0.5;
		this.yd = vy * 0.5;
		this.zd = vz * 0.5;
		this.angularVelocity = 0f;

		// Setting values of additional variables
		this.randSize = Mth.nextInt(RandomSource.create(), 25, 35) * 0.01f; // Random particle size
		this.setSize(this.randSize, this.randSize);
		this.quadSize = this.randSize;
		this.lifetime = Mth.nextInt(RandomSource.create(), 60, 80); // Random max particle lifetime
		this.initialDirection = Mth.nextInt(RandomSource.create(), 5, 12) * 0.001f * (Math.random() < 0.5 ? -1 : 1); // Direction of initial acceleration
		this.bounces = Mth.nextInt(RandomSource.create(), 2, 4); // Number of bounces
		this.accelerationBoost = Mth.nextInt(RandomSource.create(), 2, 4) * 0.0001f; // Random increase in acceleration from 0.0002f to 0.0004f
		this.interval = this.lifetime / this.bounces; // Calculating the interval
		
		if (this.age % this.interval == 0) {
		    if ((this.age / this.interval) % 2 == 0) {
		        this.angularAcceleration = this.initialDirection + this.currentBoost;  // Clockwise
		    } else {
		        this.angularAcceleration = -this.initialDirection - this.currentBoost; // Counterclockwise
		    }
		}

		this.pickSprite(spriteSet);
	}

	// Fade in and out
	public float getQuadSize(float value) {
		float f = ((float)this.age + value) / (float)this.lifetime;
		return this.quadSize * (float)Math.min(this.age * 0.1, 1) * (float)(1 - Math.max(this.age - (this.lifetime - 10), 0) * 0.1);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
		this.oRoll = this.roll;
		this.roll += this.angularVelocity;
		this.angularVelocity += this.angularAcceleration;
		
		// Calculating multiplier for acceleration that increases till midlife and decreases after that
		this.midLifeFactor = 1.0f - Math.abs((this.age - (this.lifetime / 2.0f)) / (this.lifetime / 2.0f));
		this.currentBoost = this.accelerationBoost * this.midLifeFactor;

		// Stop rotation acceleration when reaching the ground, entering a countdown
		if (onGround) {
			this.angularAcceleration = 0f;
			this.angularVelocity = 0f;
		}
		if (y > 110 || y < -16)
			this.remove();
	}
}

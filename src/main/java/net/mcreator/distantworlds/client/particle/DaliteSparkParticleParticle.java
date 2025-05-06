
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

@OnlyIn(Dist.CLIENT)
public class DaliteSparkParticleParticle extends TextureSheetParticle {
	public static DaliteSparkParticleParticleProvider provider(SpriteSet spriteSet) {
		return new DaliteSparkParticleParticleProvider(spriteSet);
	}

	public static class DaliteSparkParticleParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public DaliteSparkParticleParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new DaliteSparkParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected DaliteSparkParticleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.lifetime = 23;
		this.gravity = 0f;
		this.hasPhysics = true;
		this.xd = vx;
		this.yd = vy;
		this.zd = vz;
		this.setSpriteFromAge(spriteSet);
	}

	public float getQuadSize(float value) {
		float f = ((float)this.age + value) / (float)this.lifetime;
		return this.quadSize * (float)Math.min(this.age * 0.1, 1) * (float)(1 - Math.max(this.age - (this.lifetime - 5), 0) * 0.1);
		//return this.quadSize * (1.0F - f * f * 0.5F);
	}

	@Override
	public int getLightColor(float partialTick) {
		return 15728880;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_LIT;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.removed) {
			this.setSprite(this.spriteSet.get((this.age / 4) % 6 + 1, 6));
		}
	}
}

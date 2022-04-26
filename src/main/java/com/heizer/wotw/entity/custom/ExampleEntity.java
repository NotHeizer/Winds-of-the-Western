package com.heizer.wotw.entity.custom;

import com.heizer.wotw.entity.WotWModEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class ExampleEntity extends Animal {

    public ExampleEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

        public static AttributeSupplier setAttributes() {
            return Animal.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 20.0D)
                    .add(Attributes.ATTACK_DAMAGE, 3.0f)
                    .add(Attributes.ATTACK_SPEED, 2.0f)
                    .add(Attributes.MOVEMENT_SPEED, 0.3f)
                    .add(Attributes.FOLLOW_RANGE, 100D)
                    .build();
        }

        protected void registerGoals() {
            this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0D, true));
            this.goalSelector.addGoal(1, new FloatGoal(this));
            this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
            this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
            this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
            this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)).setAlertOthers());
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        }



        @javax.annotation.Nullable
        @Override
        public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
            ExampleEntity retval = WotWModEntityTypes.EXAMPLE.get().create(serverWorld);
            retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
            return retval;
        }

        @Override
        public boolean isFood(ItemStack stack) {
            return Objects.equals(Items.COOKED_BEEF, stack.getItem());
        }
        /**
        //Step Sound Example
        protected void playStepSound(BlockPos pos, BlockState blockIn) {
         this.playSound(SoundEvents.SAND_STEP, 0.15F, 1.0F);
         }

        //Ambient Sound Example
        protected SoundEvent getAmbientSound() {
         return SoundEvents.AMBIENT_CAVE;
         }

        protected SoundEvent getAmbientSound() {
            return SoundEvents.CAT_STRAY_AMBIENT;
        }

        protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
            return SoundEvents.DOLPHIN_HURT;
        }

        protected SoundEvent getDeathSound() {
            return SoundEvents.DOLPHIN_DEATH;
        }

        protected float getSoundVolume() {
            return 5F;
        }**/
}

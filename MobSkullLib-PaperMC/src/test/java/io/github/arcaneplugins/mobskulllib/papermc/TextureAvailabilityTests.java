package io.github.arcaneplugins.mobskulllib.papermc;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.junit.jupiter.api.Test;

public class TextureAvailabilityTests {

    /**
     * This test ensures that all LivingEntity-type entities have a skull texture.
     * We are only looking at LivingEntities here since they are the most important. There are
     * a few edge cases where a skull texture is available for a non-LivingEntity-type entity.
     */
    @Test
    void ensureTextureAvailabilities() {
        for(final EntityType et : EntityType.values()) {
            final Class<? extends Entity> ec = et.getEntityClass();
            if(ec == null) continue;
            if(!LivingEntity.class.isAssignableFrom(ec)) continue;
            MobSkullLib.getSkullTextureForEntityType(et);
        }
    }

}

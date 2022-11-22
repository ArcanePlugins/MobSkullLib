/*
Copyright (c) 2022  MobSkullLib Contributors
Usage of this class is subject to the GNU GPL v3 license.
 */
package io.github.arcaneplugins.mobskulllib.papermc;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * MobSkullLib allows Paper plugins to easily retrieve a mob skull of a given EntityType.
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class MobSkullLib extends JavaPlugin {

    private static final Map<EntityType, String> entitySkullTextureMap = new HashMap<>();

    @Nonnull
    public static String getSkullTextureForEntityType(final @Nonnull EntityType et) {
        Objects.requireNonNull(et, "EntityType cannot be null");

        return Objects.requireNonNull(
            entitySkullTextureMap.get(et),
            "MobSkullLib does not have a texture associated with EntityType '" + et + "'."
        );
    }

    @Nonnull
    public static ItemStack getSkullItemForEntityType(final @Nonnull EntityType et) {
        Objects.requireNonNull(et, "EntityType cannot be null");

        return applySkullTextureToItemStackForEntityType(
            new ItemStack(Material.PLAYER_HEAD),
            et
        );
    }

    @Nonnull
    public static ItemStack applySkullTextureToItemStackForEntityType(
        final @Nonnull ItemStack is,
        final @Nonnull EntityType et
    ) {
        /*
        Thank you to SmushyTaco for providing a guide on using Paper's API for this purpose.

        Link to thread comment:
        < https://www.spigotmc.org/threads/how-do-i-access-gameprofile.450589/#post-3873873 >

        Link to user on SpigotMC:
        < https://www.spigotmc.org/members/smushytaco.1016173/ >
         */

        Objects.requireNonNull(et, "EntityType cannot be null");

        final String texture = getSkullTextureForEntityType(et);

        final SkullMeta sm = (SkullMeta) is.getItemMeta();

        final PlayerProfile profile = sm.getPlayerProfile();
        Objects.requireNonNull(profile, "Unable to retrieve player profile of skull.");

        profile.getProperties().add(new ProfileProperty("textures", texture));

        sm.setPlayerProfile(profile);
        is.setItemMeta(sm);

        return is;
    }

    static {
        // Skull textures retrieved from < https://minecraft-heads.com/ >

        entitySkullTextureMap.put(EntityType.ALLAY, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTUwMjk0YTE3NDczMTBmMTA0MTI0YzYzNzNjYzYzOWI3MTJiYWE1N2I3ZDkyNjI5N2I2NDUxODhiN2JiOWFiOSJ9fX0=");
        entitySkullTextureMap.put(EntityType.AXOLOTL, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViZjJiMTEzZjRhODEzNzBhMWNmOWQyNTA0ZTg3NTZiNjZkZWVmNzllOTQzMzE4N2RhNzc0Yjk2YzlmMzViYSJ9fX0=");
        entitySkullTextureMap.put(EntityType.BAT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWU5OWRlZWY5MTlkYjY2YWMyYmQyOGQ2MzAyNzU2Y2NkNTdjN2Y4YjEyYjlkY2E4ZjQxYzNlMGEwNGFjMWNjIn19fQ==");
        entitySkullTextureMap.put(EntityType.BEE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWQ2NTJmMzY5Y2JmN2YzZWVmYTdhOWVmY2EwYWNjYjZmNTliMjkwZmE5OTY0ZjgwYzNlYWNiNjgwZTRiM2VhNyJ9fX0=");
        entitySkullTextureMap.put(EntityType.BLAZE, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjc4ZWYyZTRjZjJjNDFhMmQxNGJmZGU5Y2FmZjEwMjE5ZjViMWJmNWIzNWE0OWViNTFjNjQ2Nzg4MmNiNWYwIn19fQ==");
        entitySkullTextureMap.put(EntityType.CAT, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY3YjA1NWU2ZmVmOTE0ZGNkMmI4NjJhZGMwMWI4MzM4ZTc5ZTFiMjZhYzNhNzExZjg4ZDE2NzZjNDI4NjgxNSJ9fX0=");
        entitySkullTextureMap.put(EntityType.CAVE_SPIDER, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWNjYzRhMzJkNDVkNzRlOGIxNGVmMWZmZDU1Y2Q1ZjM4MWEwNmQ0OTk5MDgxZDUyZWFlYTEyZTEzMjkzZTIwOSJ9fX0=");
        entitySkullTextureMap.put(EntityType.CHICKEN, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjQ2MGMyZTNlZTgwOWU4ZWZkNTM2NjFlNTc2YTY4MzNjOGI5OWIzYmUzNzhlYzQ0ZjY2NWMyNmI3N2M2N2EifX19");
        entitySkullTextureMap.put(EntityType.COD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg5MmQ3ZGQ2YWFkZjM1Zjg2ZGEyN2ZiNjNkYTRlZGRhMjExZGY5NmQyODI5ZjY5MTQ2MmE0ZmIxY2FiMCJ9fX0=");
        entitySkullTextureMap.put(EntityType.COW, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDY1NTE4NDA5NTVmNTI0MzY3NTgwZjExYjM1MjI4OTM4YjY3ODYzOTdhOGYyZThjOGNjNmIwZWIwMWI1ZGIzZCJ9fX0=");
        entitySkullTextureMap.put(EntityType.CREEPER, null);
        entitySkullTextureMap.put(EntityType.DOLPHIN, null);
        entitySkullTextureMap.put(EntityType.DRAGON_FIREBALL, null);
        entitySkullTextureMap.put(EntityType.DROWNED, null);
        entitySkullTextureMap.put(EntityType.EGG, null);
        entitySkullTextureMap.put(EntityType.ELDER_GUARDIAN, null);
        entitySkullTextureMap.put(EntityType.ENDER_CRYSTAL, null);
        entitySkullTextureMap.put(EntityType.ENDER_DRAGON, null);
        entitySkullTextureMap.put(EntityType.ENDER_PEARL, null);
        entitySkullTextureMap.put(EntityType.ENDER_SIGNAL, null);
        entitySkullTextureMap.put(EntityType.ENDERMAN, null);
        entitySkullTextureMap.put(EntityType.ENDERMITE, null);
        entitySkullTextureMap.put(EntityType.EVOKER, null);
        entitySkullTextureMap.put(EntityType.EVOKER_FANGS, null);
        entitySkullTextureMap.put(EntityType.EXPERIENCE_ORB, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdkODg1YjMyYjBkZDJkNmI3ZjFiNTgyYTM0MTg2ZjhhNTM3M2M0NjU4OWEyNzM0MjMxMzJiNDQ4YjgwMzQ2MiJ9fX0=");
        entitySkullTextureMap.put(EntityType.FIREBALL, null);
        entitySkullTextureMap.put(EntityType.FIREWORK, null);
        entitySkullTextureMap.put(EntityType.FOX, null);
        entitySkullTextureMap.put(EntityType.FROG, null);
        entitySkullTextureMap.put(EntityType.GHAST, null);
        entitySkullTextureMap.put(EntityType.GIANT, null);
        entitySkullTextureMap.put(EntityType.GLOW_SQUID, null);
        entitySkullTextureMap.put(EntityType.GOAT, null);
        entitySkullTextureMap.put(EntityType.GUARDIAN, null);
        entitySkullTextureMap.put(EntityType.HOGLIN, null);
        entitySkullTextureMap.put(EntityType.HORSE, null);
        entitySkullTextureMap.put(EntityType.HUSK, null);
        entitySkullTextureMap.put(EntityType.ILLUSIONER, null);
        entitySkullTextureMap.put(EntityType.IRON_GOLEM, null);
        entitySkullTextureMap.put(EntityType.LIGHTNING, null);
        entitySkullTextureMap.put(EntityType.LLAMA, null);
        entitySkullTextureMap.put(EntityType.MAGMA_CUBE, null);
        entitySkullTextureMap.put(EntityType.MARKER, null);
        entitySkullTextureMap.put(EntityType.MINECART, null);
        entitySkullTextureMap.put(EntityType.MINECART_CHEST, null);
        entitySkullTextureMap.put(EntityType.MINECART_COMMAND, null);
        entitySkullTextureMap.put(EntityType.MINECART_FURNACE, null);
        entitySkullTextureMap.put(EntityType.MINECART_HOPPER, null);
        entitySkullTextureMap.put(EntityType.MINECART_MOB_SPAWNER, null);
        entitySkullTextureMap.put(EntityType.MINECART_TNT, null);
        entitySkullTextureMap.put(EntityType.MULE, null);
        entitySkullTextureMap.put(EntityType.MUSHROOM_COW, null);
        entitySkullTextureMap.put(EntityType.OCELOT, null);
        entitySkullTextureMap.put(EntityType.PAINTING, null);
        entitySkullTextureMap.put(EntityType.PANDA, null);
        entitySkullTextureMap.put(EntityType.PARROT, null);
        entitySkullTextureMap.put(EntityType.PHANTOM, null);
        entitySkullTextureMap.put(EntityType.PIG, null);
        entitySkullTextureMap.put(EntityType.PIGLIN, null);
        entitySkullTextureMap.put(EntityType.PIGLIN_BRUTE, null);
        entitySkullTextureMap.put(EntityType.PILLAGER, null);
        entitySkullTextureMap.put(EntityType.PLAYER, null);
        entitySkullTextureMap.put(EntityType.POLAR_BEAR, null);
        entitySkullTextureMap.put(EntityType.PRIMED_TNT, null);
        entitySkullTextureMap.put(EntityType.PUFFERFISH, null);
        entitySkullTextureMap.put(EntityType.RABBIT, null);
        entitySkullTextureMap.put(EntityType.RAVAGER, null);
        entitySkullTextureMap.put(EntityType.SALMON, null);
        entitySkullTextureMap.put(EntityType.SHEEP, null);
        entitySkullTextureMap.put(EntityType.SHULKER, null);
        entitySkullTextureMap.put(EntityType.SHULKER_BULLET, null);
        entitySkullTextureMap.put(EntityType.SILVERFISH, null);
        entitySkullTextureMap.put(EntityType.SKELETON, null);
        entitySkullTextureMap.put(EntityType.SKELETON_HORSE, null);
        entitySkullTextureMap.put(EntityType.SLIME, null);
        entitySkullTextureMap.put(EntityType.SMALL_FIREBALL, null);
        entitySkullTextureMap.put(EntityType.SNOWBALL, null);
        entitySkullTextureMap.put(EntityType.SNOWMAN, null);
        entitySkullTextureMap.put(EntityType.SPIDER, null);
        entitySkullTextureMap.put(EntityType.SQUID, null);
        entitySkullTextureMap.put(EntityType.STRAY, null);
        entitySkullTextureMap.put(EntityType.STRIDER, null);
        entitySkullTextureMap.put(EntityType.TADPOLE, null);
        entitySkullTextureMap.put(EntityType.TRADER_LLAMA, null);
        entitySkullTextureMap.put(EntityType.TROPICAL_FISH, null);
        entitySkullTextureMap.put(EntityType.TURTLE, null);
        entitySkullTextureMap.put(EntityType.VEX, null);
        entitySkullTextureMap.put(EntityType.VILLAGER, null);
        entitySkullTextureMap.put(EntityType.VINDICATOR, null);
        entitySkullTextureMap.put(EntityType.WANDERING_TRADER, null);
        entitySkullTextureMap.put(EntityType.WARDEN, null);
        entitySkullTextureMap.put(EntityType.WITCH, null);
        entitySkullTextureMap.put(EntityType.WITHER, null);
        entitySkullTextureMap.put(EntityType.WITHER_SKELETON, null);
        entitySkullTextureMap.put(EntityType.WITHER_SKULL, null);
        entitySkullTextureMap.put(EntityType.WOLF, null);
        entitySkullTextureMap.put(EntityType.ZOGLIN, null);
        entitySkullTextureMap.put(EntityType.ZOMBIE, null);
        entitySkullTextureMap.put(EntityType.ZOMBIE_HORSE, null);
        entitySkullTextureMap.put(EntityType.ZOMBIE_VILLAGER, null);
        entitySkullTextureMap.put(EntityType.ZOMBIFIED_PIGLIN, null);
    }

}

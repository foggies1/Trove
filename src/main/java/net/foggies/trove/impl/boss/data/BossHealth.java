package net.foggies.trove.impl.boss.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.utils.HologramUtils;
import net.foggies.trove.utils.Number;
import org.bukkit.EntityEffect;

@AllArgsConstructor
@Getter
@Setter
public class BossHealth {

    private final TroveBoss parent;
    private double current;
    private double max;

    public void giveHealth(double amount) {
        if (getCurrent() + amount > max) amount = max - getCurrent();
        setCurrent(getCurrent() + amount);
    }

    public boolean takeHealth(double damage) {
        displayDamage(damage);

        if (getCurrent() - damage < 0) {
            parent.getEntity().playEffect(EntityEffect.ENTITY_POOF);
            parent.getEntity().remove();
            return true;
        }

        setCurrent(getCurrent() - damage);
        parent.updateName(parent.getEntity());
        return false;
    }

    public void displayDamage(double dmg) {
        HologramUtils.spawnHologram(
                parent.getBossesCurrentLocation(),
                "&e" + Number.pretty(dmg)
        );
    }

    public String prettified() {
        return Number.pretty(current) + "/" + Number.pretty(max);
    }

}

package net.foggies.trove.impl.player.trovian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TrovianHealth {

    private double currentHealth;
    private double maxHealth;

    public void addCurrentHealth(double amount){
        setCurrentHealth(getCurrentHealth() + amount);
    }

    public void addMaxHealth(double amount){
        setMaxHealth(getMaxHealth() + amount);
    }

    public boolean takeCurrentHealth(double amount) {
        if (getCurrentHealth() - amount <= 0) {
            setCurrentHealth(getMaxHealth());
            return true;
        }

        setCurrentHealth(getCurrentHealth() - amount);
        return false;
    }

}

package net.foggies.trove.impl.player.trovian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DustData {

    private long waterDust;
    private long airDust;
    private long fireDust;
    private long cosmicDust;

    public long getDustAmount(String type){
        switch (type.toLowerCase()){
            case "water" -> {
                return getWaterDust();
            }
            case "air" -> {
                return getAirDust();
            }
            case "fire" -> {
                return getFireDust();
            }
            case "cosmic" -> {
                return getCosmicDust();
            }
        }
        return 0L;
    }

    public void addDust(String type, long amount) {
        switch (type.toLowerCase()) {
            case "water" -> setWaterDust(getWaterDust() + amount);
            case "air" -> setAirDust(getAirDust() + amount);
            case "fire" -> setFireDust(getFireDust() + amount);
            case "cosmic" -> setCosmicDust(getCosmicDust() + amount);
        }
    }

    public void removeDust(String type, long amount) {
        switch (type.toLowerCase()) {
            case "water" -> {
                if (getWaterDust() - amount < 0) amount = getWaterDust();
                setWaterDust(getWaterDust() - amount);
            }
            case "air" ->  {
                if (getAirDust() - amount < 0) amount = getAirDust();
                setAirDust(getAirDust() - amount);
            }
            case "fire" -> {
                if (getFireDust() - amount < 0) amount = getFireDust();
                setFireDust(getFireDust() - amount);
            }
            case "cosmic" ->  {
                if (getCosmicDust() - amount < 0) amount = getCosmicDust();
                setCosmicDust(getCosmicDust() - amount);
            }
        }
    }

}

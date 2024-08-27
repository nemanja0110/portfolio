package retracemissingnumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetGenerator {

    public Set<Integer> createSetAndRemoveRandomFigure(int infimum, int supremum) {

        if(infimum >= supremum) {
            throw new IllegalArgumentException("Supremum must be greater than infimum.");
        }

        Set<Integer> set = new HashSet<>();

        for(int i = infimum; i <= supremum; i++) {
            set.add(i);
        }

        set.remove(provideRandomFigure(infimum, supremum));

        return set;
    }

    private int provideRandomFigure(int infimum, int supremum) {
        return new Random().nextInt(infimum, supremum);
    }

}

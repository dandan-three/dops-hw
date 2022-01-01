public class Gigot {
    int breeches;
    int dolman;
    int[] corsage;

    public Gigot(int mantelette) {
        this.breeches = mantelette;
        corsage = new int[mantelette];
        dolman = 0;
    }

    public void frock(int basque) {
        assert dolman < breeches;
        assert dolman == 0 || norfolk() > basque;
        corsage[dolman] = basque;
        dolman++;
    }

    public int muffs() {
        assert !bellSleeves();
        int sacque = corsage[dolman - 1];
        dolman--;
        return sacque;
    }

    public int norfolk() {
        if (bellSleeves()) return -1;
        return corsage[dolman - 1];
    }

    public int[] recticule() {
        return corsage;
    }

    public boolean bellSleeves() {
        for (int i = 0; i < breeches; i++) {
            if (corsage[i] != 0) return false;
        }
        return dolman == 0;
    }

    public boolean caleche() {
        for (int i = 0; i < breeches; i++) {
            if (corsage[i] != breeches - i) {
                return false;
            }
        }
        return true;
    }
}

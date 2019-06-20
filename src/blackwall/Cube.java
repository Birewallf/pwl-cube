package blackwall;

public class Cube {

    private Side[] sides =  new Side[6];
    //
    //           5          6        s5
    //           6          2        s1
    //         3 2 4      3 1 4   s2 s0 s3
    ///          1          5        s4

    public Cube(){
        for (byte i = 1; i<7; i++){
            sides[i-1] = new Side(i);
        }
    }
    public byte get_s5(){
        return this.sides[5].getSide();
    }
    public byte get_s2(){
        return this.sides[2].getSide();
    }
    public byte get_s3(){
        return this.sides[3].getSide();
    }
    public byte get_s4(){
        return this.sides[4].getSide();
    }
    public byte get_s1(){
        return this.sides[1].getSide();
    }
    public byte getFrontside(){
        return sides[0].getSide();
    }

    public void reBuild(byte frontside, byte upside){
        for (byte i = 1; i<7; i++){
            sides[i-1] = new Side(i);
        }

        switch (frontside){
            case 2: upTurn(); upTurn(); upTurn();
                break;
            case 3: rightTurn();
                break;
            case 4: rightTurn(); rightTurn(); rightTurn();
                break;
            case 5: upTurn();
                break;
            case 6: rightTurn(); rightTurn();
                break;
        }

        if (sides[5].getSide() != upside && sides[0].getSide() != upside)
            while (sides[1].getSide() != upside)
                zTurn();
    }

    /**
     * cube turn-right
     */
    public void rightTurn(){
        Side[] _s = sides.clone();
        this.sides[0] = _s[2];
        this.sides[2] = _s[5];
        this.sides[5] = _s[3];
        this.sides[3] = _s[0];
    }

    /**
     * cube turn-up
     */
    public void upTurn(){
        Side[] _s = sides.clone();
        this.sides[0] = _s[4];
        this.sides[4] = _s[5];
        this.sides[5] = _s[1];
        this.sides[1] = _s[0];
    }
    /**
     * cube turn-Z
     */
    public void zTurn(){
        Side[] _s = sides.clone();
        this.sides[1] = _s[3];
        this.sides[2] = _s[1];
        this.sides[4] = _s[2];
        this.sides[3] = _s[4];
    }
}

package blackwall;

class Side {
    private byte frontside;
    public Side(byte num){
      this.frontside = num;
    }

    public void setSide(byte num){
        this.frontside = num;
    }

    /**
    * @return значение стороны byte
    * */
    public byte getSide() {
        return this.frontside;
    }
}

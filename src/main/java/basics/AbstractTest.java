package basics;

public abstract class AbstractTest {

    public int getNum() {
        return 45;
    }

    public abstract class Bar {
        public int getNum() {
            return 38;
        }
    }


    public static void main(String[] args) {
        AbstractTest t = new AbstractTest() {
            public int getNum() {
                return 22;
            }
        };


        AbstractTest ta = new AbstractTest() {
            @Override
            public int getNum() {
                return super.getNum();
            }
        };

        AbstractTest.Bar f = t.new Bar() {
            @Override
            public int getNum() {
                return 57;
            }
        };

        System.out.println(ta.getNum() + " " + t.getNum());


    }
}

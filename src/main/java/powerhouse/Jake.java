package powerhouse;

public class Jake {


    private boolean isMethod() {
        return false;
    }

    private boolean isNewMethod(String p) {
        return false;
    }

    private void performDB(String str, Object b, Integer a, int v) {
        System.out.println("DB call");
    }


    public void sendRequest(String json, String text) {

        if (isNewMethod(text)) {

            performDB(text, text, 1,1);
            System.out.println("hello");
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean replaceData(final String dataId, final int num) {
        return modifyData(dataId, num);
    }

    public boolean deleteData(final String dataId) {
        return modifyData(dataId, 0);
    }


    private boolean modifyData(final String dataId, int num) {

        return true;
    }
}

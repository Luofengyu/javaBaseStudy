package base;

/**
 * InArrayClassAddress class
 *
 * 在数组中的类的地址是否指向同一个
 *
 * @author xiwang
 * @date 2019-08-28
 */
public class InArrayClassAddress {

    private String name;
    public void setName(String nName){
        this.name = nName;
    }
    public String getName(){
        return this.name;
    }

    /**
     * 输出结果
     * test1: arrIndex1
     * arr[0]: arrIndex1
     * arr[1]: arrIndex1
     * */
    public static void main(String[] args){
        InArrayClassAddress[] arr = new InArrayClassAddress[2];
        InArrayClassAddress test1 = new InArrayClassAddress();
        for(int i=0; i<2; i++){
            arr[i] = test1;
            arr[i].setName("arrIndex"+ i);
        }
        System.out.println("test1: " + test1.getName());
        for(int i=0; i<2; i++){
            System.out.println("arr["+ i + "]: " + arr[i].getName());
        }

    }

}

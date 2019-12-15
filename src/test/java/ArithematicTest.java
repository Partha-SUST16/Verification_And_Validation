import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class ArithematicTest {
    private static int first,second,result;
    private static Arithematic arithematic;

//    public ArithematicTest(int first, int second, int result) {
//        super();
//        this.first = first;
//        this.second = second;
//        this.result = result;
//    }
    @BeforeAll
    public static void ini(){
        arithematic = new Arithematic();
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void BasicTest(int i){
        System.out.println(i);
        assertTrue(arithematic.sum(1,2)==i);
    }
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "2,3,5"})
    public void Basic2(int a,int b,int res){
        assertTrue(arithematic.sum(a,b)==res);
    }
}
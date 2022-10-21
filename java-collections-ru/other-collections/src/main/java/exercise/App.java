package exercise;

import java.util.*;

// BEGIN
class App {
    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>(
                Map.of("one", "eon", "two", "two", "four", true)
        );
        System.out.println(data1); //=> {two=two, four=true, one=eon}

        Map<String, Object> data2 = new HashMap<>(
                Map.of("two", "own", "zero", 4, "four", true)
        );
        System.out.println(data2); //=> {zero=4, two=own, four=true}

        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }

    public static LinkedHashMap<String, String> genDiff(Map<String, Object> a, Map<String, Object> b) {
        Set<String> aa = a.keySet();
        Set<String> bb = b.keySet();
        Set<String> cc = new HashSet<>();
        cc.addAll(aa);
        cc.addAll(bb);
        LinkedHashMap<String, String> res = new LinkedHashMap<>();
        for (var x:cc) {
            if (bb.contains(x) && !aa.contains(x)){
                res.put(x, "added");
            }
            else if (!bb.contains(x) && aa.contains(x)){
                res.put(x, "deleted");
            }
            else if (bb.contains(x) && aa.contains(x) && b.get(x).equals(a.get(x))){
                res.put(x, "unchanged");
            }
            else {
                res.put(x, "changed");
            }
        }
        return res;
    }
}
//END

package bg.smg;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc=null;
        List <Apartments> list=new ArrayList<>();
        Set<String> gradove=new HashSet<>();
        gradove.add("Варна");
        gradove.add("Бургас");
        gradove.add("София");

        Set<Integer> stai=new HashSet<>();
        stai.add(1);
        stai.add(2);
        stai.add(3);
        Map<String, Integer> brokeriPhone=new HashMap<>();

        Map<String, Double> kwadraturi=new HashMap<>();
        try{
            Path resource = Paths.get("src");
            String absolutepath = resource.toFile().getAbsolutePath();
            File file = new File(absolutepath + "/testData_Apartments.txt");
            sc=new Scanner(file);

            while(sc.hasNext()){
                String city=sc.next();
                int rooms=sc.nextInt();
                double kwadratura=sc.nextDouble();
                double price=sc.nextDouble();
                String phone=sc.next();
                Apartments a=new Apartments(city, rooms,kwadratura, price,phone);
                if (!gradove.contains(city)) continue;
                if (!stai.contains(rooms))continue;
                if (kwadraturi.containsValue(kwadratura))continue;
                if (brokeriPhone.containsKey(phone)){
                    brokeriPhone.put(phone, brokeriPhone.get(phone)+1);
                } else{
                    brokeriPhone.put(phone, 1);
                }


            }
        } catch (FileNotFoundException e) {
            UnsuitableApartmentsException ex=new UnsuitableApartmentsException();
            String m=new String("Nqma takiwa apartamenti.");


        } finally {
            assert sc!=null;
            sc.close();
        }
        private static HashMap<String, Integer> sortByValue(Map<String,Integer> hm){
            List<Map.Entry<String, Inhteger>> list=new LinkedList<>(hm.entrySet());
            list.sort(new Comparator<Map.Entry<String, Integer>>()){
                public int compare(Map.Entry<String, Integer>o1, Map.Entry<String, Integer>02){
                    return(01.getValue()).compareTo(o2.getValue());
                }
            }
        }
    }

}

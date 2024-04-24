package bg.smg;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws UnsuitableApartmentsException {

        Scanner sc=null;
        List <Apartments> list=new ArrayList<>();
        Set<String> gradove=new HashSet<>();
        gradove.add("Варна");
        gradove.add("Бургас");
        gradove.add("София");

        Map<String, Double> phonePrice=new HashMap<>();
        Map<String, Integer> cityApCounter=new HashMap<>();
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
                if (!gradove.contains(city)|| rooms !=3 || kwadratura<100) continue;
                if (cityApCounter.containsKey(city))
                    cityApCounter.put(city, cityApCounter.get(city)+1);
                else
                    cityApCounter.put(city, 1);
                phonePrice.put (phone, price);
            }
        } catch (FileNotFoundException e) {
        } finally {
            assert sc!=null;
            sc.close();
        }
        if (phonePrice.size()==0) throw new UnsuitableApartmentsException("Nqma takiwa apartamenti");

        List<Map.Entry<String, Integer>> cityList = new ArrayList<>(cityApCounter.entrySet());
        cityList.sort(Map.Entry.comparingByValue());
        List<Map.Entry<String, Double>> brokerList = new ArrayList<>(phonePrice.entrySet());
        brokerList.sort(Map.Entry.comparingByValue());

        File file2 = new File("output.txt");
        if (file2.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(file2);
            for (int i=0; i<5; i++) output.println (brokerList.get(i).getKey());
            output.println (cityList.get(2).getKey());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            assert output != null;
            output.close();
        }
    }

}

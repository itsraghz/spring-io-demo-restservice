package com.example.util;


import com.example.bo.CardHolder;
import com.example.bo.Corporate;
import com.example.bo.ProgramAdmin;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.smartcardio.Card;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Data
@EqualsAndHashCode
public class CorpPGAdminUtil {

    public static Map<String, Corporate> corporateMap = new HashMap<>();
    public static List<Corporate> corporateList = new ArrayList<>();
    public static List<CardHolder> cardHolderList = new ArrayList<>();
    public static Map<String, List<CardHolder>> cardHolderMap = new HashMap<>();
    public static Map<String, List<ProgramAdmin>> pgAdminMap = new HashMap<>();

    private static final String[] corpNamesArray = new String[] { "TCS", "Infy", "Wipro", "Citi", "Accenture"};
    private static final String[] countryNamesArray = new String[] { "India", "Singapore", "Europe", "UK", "USA"};
    private static final String[] cityNamesArray = new String[] { "Chennai", "Singapore", "Germany", "London", "Texas"};
    private static final String[] cardTypeArray = new String[] { "C", "I"};
    private static final String[] yesNoArray = new String[] { "Y", "N"};
    private static final String[] cardStatusArray = new String[] { "A", "D"};
    private static final String[] firstNameArray = new String[] {"Muthu", "Raghavan", "Roberto", "Frank", "Xavier", "Anees", "Ravi", "Manoj", "Sathia", "Chandramouli", "Lakshmanan", "Couppusamy", "Sriram", "Rajdip", "Saurabh", "Sundaresan", "George", "Mahemed", "Rajkumar", "Edward", "Vinayagam", "Alaguraja", "Sathis Kumar"};
    private static final String[] lastNameArray = new String[] {"Krishnan", "Muthu", "Chavez", "Jonathan", "Prakash", "Ahmed", "Ranjan", "Sutradhar", "Priya", "Ramamoorthy", "Sathyamurthy", "Perumal", "Venkitesan", "Deb", "Kumar", "Kannappan", "Philips", "Rafiuddin", "Anbazhagan", "Javier", "Vineeth", "Balasubramaniam", "Abhishek"};

    private static Faker faker = new Faker();
    private static Random random = new Random();
    private static AtomicLong corpCounter = new AtomicLong();
    private static AtomicLong cardHolderCounter = new AtomicLong();

    static {
        initCorporates();
        initCardHolders();
        initPGAdmins();
    }

    public static void print() {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("            Datasets being prepared       ");
        System.out.println("==========================================");

        System.out.println(" ** Corporate List **");
        System.out.println("______________________");
        List<Corporate> _corporateList = CorpPGAdminUtil.corporateList;
        for(Corporate corporate : _corporateList) {
            System.out.println(corporate);
        }

        System.out.println(" ** CardHolder List **");
        System.out.println("______________________");
        List<CardHolder> _cardHolderList = CorpPGAdminUtil.cardHolderList;
        for(CardHolder cardHolder : _cardHolderList) {
            System.out.println(cardHolder);
        }

        System.out.println(" ** CardHolder Map **");
        System.out.println("______________________");
        Map<String, List<CardHolder>> _cardHolderMap = CorpPGAdminUtil.cardHolderMap;
        for(Map.Entry<String, List<CardHolder>> entry : _cardHolderMap.entrySet()) {
            System.out.println(" /// May Key - " + entry.getKey() + " ///");
            List<CardHolder> _cardHolderListForKey = entry.getValue();
            for(CardHolder cardHolder : _cardHolderListForKey) {
                System.out.println(" #### CardHolder ---> " + cardHolder);
            }
        }
    }

    <T> T randomValue(T[] values) {
        return values[random.nextInt(values.length)];
        //MyEnum value = randomValue(MyEnum.values());
    }

    public static void initCorporates() {

        System.out.println("[*] initCorporates invoked...");

        Corporate corporate = null;

        for(int i = 0; i < 5; i++) {
            corporate = new Corporate();

            corporate.setId(corpCounter.incrementAndGet());
            corporate.setCreatedDate(new Date());

            corporate.setOrgId(String.valueOf(faker.number().numberBetween(101, 999)));
            corporate.setCorpId(String.valueOf(faker.number().numberBetween(111111111, 999999999)));
            //corporate.setName(String.valueOf(faker.company().name()));
            //corporate.setCity(faker.address().cityName());
            //corporate.setCountry(faker.country().name());

            corporate.setName(corpNamesArray[faker.number().numberBetween(0, corpNamesArray.length-1)]);
            int randomIndex = faker.number().numberBetween(0, cityNamesArray.length-1);
            corporate.setCity(cityNamesArray[randomIndex]);
            corporate.setCountry(countryNamesArray[randomIndex]);

            CorpPGAdminUtil.corporateList.add(corporate);
        }
    }

    public static void prepareCardHolders(String orgId) {
        System.out.println("[*] prepareCardHolders invoked...");

        CardHolder cardHolder = null;

        List<CardHolder> cardHolderListTemp = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            cardHolder = new CardHolder();

            cardHolder.setId(cardHolderCounter.incrementAndGet());
            cardHolder.setCreatedDate(new Date());

            cardHolder.setCardNumber(String.valueOf(faker.number().numberBetween(100000000, 999999999)));
            cardHolder.setOrgId(orgId);
            cardHolder.setCorporateId(String.valueOf(faker.number().numberBetween(111111111, 999999999)));
            int randomIndex = faker.number().numberBetween(0, firstNameArray.length);
            cardHolder.setFirstName(firstNameArray[randomIndex]);
            cardHolder.setLastName(lastNameArray[randomIndex]);
            cardHolder.setCardType(cardTypeArray[faker.number().numberBetween(0, cardTypeArray.length)]);
            cardHolder.setIsBlocked(yesNoArray[faker.number().numberBetween(0, yesNoArray.length)]);
            cardHolder.setStatus(cardStatusArray[faker.number().numberBetween(0, cardStatusArray.length)]);
            cardHolder.setBalance(faker.number().randomDouble(2, 0, 999999));
            cardHolder.setExpiryDate(faker.date().future(9999, TimeUnit.DAYS));

            System.out.println("cardHolder :: " + cardHolder.toString());

            cardHolderListTemp.add(cardHolder);
        }

        CorpPGAdminUtil.cardHolderMap.put(orgId, cardHolderListTemp);
        CorpPGAdminUtil.cardHolderList.addAll(cardHolderListTemp);
    }

    public static void initCardHolders() {
        System.out.println("[*] initCardHolders invoked...");

        String orgId=null;
        Set<String> orgIdSet = new HashSet<>();
        List<Corporate> _corporateList = CorpPGAdminUtil.corporateList;
        int limit = CorpPGAdminUtil.corporateList.size();
        limit = 3;

        for(int i=0; i< limit ; i++) {
            System.out.println(" [**] Iteration Count : " + i);
            orgId = _corporateList.get(faker.number().numberBetween(0, corporateList.size())).getOrgId();

            System.out.println(" [-->] Random Org Id :: " +orgId);

            while(orgIdSet.contains(orgId)) {
                orgId = _corporateList.get(faker.number().numberBetween(0, corporateList.size())).getOrgId();
                System.out.println(" [-->] ...... #ReAttempt ...... Random Org Id :: " +orgId);
            }
            prepareCardHolders(orgId);
            orgIdSet.add(orgId);
        }
    }

    public static void initPGAdmins() {
        System.out.println("[*] initPGAdmins invoked...");
    }


    public static void addCustomer(CardHolder customer) {
        System.out.println("[*] addCustomer invoked...");
    }

    public static List<CardHolder> getCardHoldersByOrgId(String orgId)  {
        return CorpPGAdminUtil.cardHolderMap.get(orgId);
    }
}

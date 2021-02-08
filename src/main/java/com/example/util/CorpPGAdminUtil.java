package com.example.util;


import com.example.bo.CardHolder;
import com.example.bo.CorpCards;
import com.example.bo.Corporate;
import com.example.bo.ProgramAdmin;
import com.example.bo.meta.CorporateMetaData;
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

    public static List<CorpCards> corpCardsList = new ArrayList<>();
    public static Map<String, Corporate> corpCardsMap = new HashMap<>();

    public static List<ProgramAdmin> pgAdminList = new ArrayList<>();
    public static Map<String, List<ProgramAdmin>> pgAdminMap = new HashMap<>();

    private static final String[] corpNamesArray = new String[] { "TCS", "Infy", "Wipro", "Citi", "Accenture"};
    private static final String[] countryNamesArray = new String[] { "India", "Singapore", "Europe", "UK", "USA"};
    private static final String[] cityNamesArray = new String[] { "Chennai", "Singapore", "Germany", "London", "Texas"};
    private static final String[] cardTypeArray = new String[] { "C", "I"};
    private static final String[] yesNoArray = new String[] { "Y", "N"};
    private static final String[] cardStatusArray = new String[] { "A", "I"};
    private static final String[] firstNameArray = new String[] {"Muthu", "Raghavan", "Roberto", "Frank", "Xavier", "Anees", "Ravi", "Manoj", "Sathia", "Chandramouli", "Lakshmanan", "Couppusamy", "Sriram", "Rajdip", "Saurabh", "Sundaresan", "George", "Mahemed", "Rajkumar", "Edward", "Vinayagam", "Alaguraja", "Sathis Kumar"};
    private static final String[] lastNameArray = new String[] {"Krishnan", "Muthu", "Chavez", "Jonathan", "Prakash", "Ahmed", "Ranjan", "Sutradhar", "Priya", "Ramamoorthy", "Sathyamurthy", "Perumal", "Venkitesan", "Deb", "Kumar", "Kannappan", "Philips", "Rafiuddin", "Anbazhagan", "Javier", "Vineeth", "Balasubramaniam", "Abhishek"};
    private static final String[] pgAdminStatusArray = new String[] { "A", "D"};
    private static final String[] pgAdminTypeArray = new String[] { "C - Central PA", "A - Authorizing Officer", "P - Primary PA", "M - Master PA", "N - No PA"};
    private static final String[] pgAdminNamesArray = new String[] { "CPA - Test", "ACRS - Test", "PPA - Test", "MPA - Test", "NPA - Test"};
    private static final String[] pgBillingEntityArray = new String[] { "ABC", "PQR", "XYZ"};
    private static final String[] pgAccessRightsArray = new String[] { "Maker", "Checker", "Both"};

    private static Faker faker = new Faker();
    private static Random random = new Random();
    private static AtomicLong corpCounter = new AtomicLong();
    private static AtomicLong cardHolderCounter = new AtomicLong();
    private static AtomicLong pgAdminCounter = new AtomicLong();

    static {
        initCorporates();
        initCardHolders();
        initPGAdmins();
    }

    public static void printMetadata() {

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

        System.out.println();
        System.out.println(" ** CardHolder List **");
        System.out.println("______________________");
        List<CardHolder> _cardHolderList = CorpPGAdminUtil.cardHolderList;
        for(CardHolder cardHolder : _cardHolderList) {
            System.out.println(cardHolder);
        }

        System.out.println();
        System.out.println(" ** CardHolder Map **");
        System.out.println("______________________");
        Map<String, List<CardHolder>> _cardHolderMap = CorpPGAdminUtil.cardHolderMap;
        for(Map.Entry<String, List<CardHolder>> entry : _cardHolderMap.entrySet()) {
            System.out.println(" /// Corporate/Org ID - " + entry.getKey() + " ///");
            List<CardHolder> _cardHolderListForKey = entry.getValue();
            for(CardHolder cardHolder : _cardHolderListForKey) {
                System.out.println(" #### CardHolder ---> " + cardHolder);
            }
        }

        System.out.println();
        System.out.println(" ** PGAdmin List **");
        System.out.println("______________________");
        List<ProgramAdmin> _pgAdminList = CorpPGAdminUtil.pgAdminList;
        for(ProgramAdmin _pgAdmin : _pgAdminList) {
            System.out.println(_pgAdmin);
        }

        System.out.println();
        System.out.println(" ** ProgramAdmin Map **");
        System.out.println("______________________");
        Map<String, List<ProgramAdmin>> _pgAdminMap = CorpPGAdminUtil.pgAdminMap;
        for(Map.Entry<String, List<ProgramAdmin>> entry : _pgAdminMap.entrySet()) {
            System.out.println(" /// Corporate/Org ID - " + entry.getKey() + " ///");
            List<ProgramAdmin> _pgAdminListForKey = entry.getValue();
            for(ProgramAdmin _pgAdmin : _pgAdminListForKey) {
                System.out.println(" #### ProgramAdmin ---> " + _pgAdmin);
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
        //CorpCards corporate = null;

        for(int i = 0; i < 5; i++) {
            corporate = new Corporate();
            //corporate = new CorpCards();

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
            CorpPGAdminUtil.corporateMap.put(corporate.getOrgId(), corporate);

            //CorpPGAdminUtil.corpCardsList.add(corporate);
        }

        System.out.println("CorporateList :: ");
        for(Corporate _corporate : corporateList) {
            System.out.println("..... " + _corporate);
        }
    }

    public static CardHolder createCardHolder(String orgId) {
        CardHolder cardHolder = new CardHolder();

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

        return cardHolder;
    }

    public static void prepareCardHolders(String orgId) {
        System.out.println("[*] prepareCardHolders invoked...");

        CardHolder cardHolder = null;

        List<CardHolder> cardHolderListTemp = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            cardHolder = createCardHolder(orgId);
            //addCardHolderToCorporate(orgId, cardHolder);
            cardHolderListTemp.add(cardHolder);
        }

        CorpPGAdminUtil.cardHolderMap.put(orgId, cardHolderListTemp);
        CorpPGAdminUtil.cardHolderList.addAll(cardHolderListTemp);
    }

    public static void addCardHolderToCorporate(String orgId, CardHolder cardHolder)
    {
        //Corporate corporate = CorpPGAdminUtil.corpCardsMap.get(orgId);
        CorpPGAdminUtil.corporateMap.get(orgId).getCardHolderList().add(cardHolder);
    }

    public static List<Corporate> addCardHolderToCorporate()
    {
        Set<String> keySet = CorpPGAdminUtil.corporateMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<Corporate> corporateListToReturn = new ArrayList<>();

        String key = null;
        List<CardHolder> cardHolderList = null;
        Corporate corporate  = null;

        while(iterator.hasNext()) {
            key = iterator.next();
            cardHolderList = CorpPGAdminUtil.cardHolderMap.get(key);
            corporate = CorpPGAdminUtil.corporateMap.get(key);
            corporate.setCardHolderList(cardHolderList);

            corporateListToReturn.add(corporate);
        }

        return corporateListToReturn;
    }

    public static Corporate addCardHolderToCorporateForOrgId(String orgId)
    {
        Set<String> keySet = CorpPGAdminUtil.corporateMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<CardHolder> cardHolderList = null;
        Corporate corporate  = null;

        cardHolderList = CorpPGAdminUtil.cardHolderMap.get(orgId);
        corporate = CorpPGAdminUtil.corporateMap.get(orgId);
        corporate.setCardHolderList(cardHolderList);

        return corporate;
    }


    public static void initCardHolders() {
        System.out.println("[*] initCardHolders invoked...");

        initMetadataForCorporate("CardHolder");
    }

    public static void preparePGAdmins(String orgId) {
        System.out.println("[*] preparePGAdmins invoked...");

        ProgramAdmin pgAdmin = null;

        List<ProgramAdmin> programAdminListTemp = new ArrayList<>();
        int randomIndexPGBillingEntity = 0, randomIndexPGAccessRights = 0, randomIndexPGAdminType = 0, randomIndexPGAdminName = 0;

        for(int i = 0; i < 6; i++) {
            pgAdmin = new ProgramAdmin();

            pgAdmin.setId(pgAdminCounter.incrementAndGet());
            pgAdmin.setCreatedDate(new Date());

            pgAdmin.setOrgId(orgId);
            pgAdmin.setCorporateId(String.valueOf(faker.number().numberBetween(111111111, 999999999)));
            pgAdmin.setPgAdminId(String.valueOf(faker.number().numberBetween(100000000, 999999999)));

            randomIndexPGAdminName = faker.number().numberBetween(0, pgAdminNamesArray.length);
            pgAdmin.setPgAdminName(pgAdminNamesArray[randomIndexPGAdminName]);

            randomIndexPGBillingEntity = faker.number().numberBetween(0, pgBillingEntityArray.length);
            pgAdmin.setBillingEntity(pgBillingEntityArray[randomIndexPGBillingEntity]);

            randomIndexPGAccessRights = faker.number().numberBetween(0, pgAccessRightsArray.length);
            pgAdmin.setAccessRights(pgAccessRightsArray[randomIndexPGAccessRights]);

            pgAdmin.setStatus(pgAdminStatusArray[faker.number().numberBetween(0, pgAdminStatusArray.length)]);

            randomIndexPGAdminType = faker.number().numberBetween(0, pgAdminTypeArray.length);
            pgAdmin.setPgAdminType(pgAdminTypeArray[randomIndexPGAdminType]);

            System.out.println("pgAdmin :: " + pgAdmin.toString());

            programAdminListTemp.add(pgAdmin);
        }

        CorpPGAdminUtil.pgAdminMap.put(orgId, programAdminListTemp);
        CorpPGAdminUtil.pgAdminList.addAll(programAdminListTemp);
    }

    public static void initPGAdmins() {

        System.out.println("[*] initPGAdmins invoked...");

        initMetadataForCorporate("PGAdmin");
    }

    private static void initMetadataForCorporate(String type) {
        String orgId=null;
        Set<String> orgIdSet = new HashSet<>();
        List<Corporate> _corporateList = CorpPGAdminUtil.corporateList;
        int limit = CorpPGAdminUtil.corporateList.size();
        //limit = 3;

        for(int i=0; i< limit ; i++) {
            System.out.println(" [**] Iteration Count : " + i);
            orgId = _corporateList.get(faker.number().numberBetween(0, corporateList.size())).getOrgId();

            System.out.println(" [-->] Random Org Id :: " +orgId);

            while(orgIdSet.contains(orgId)) {
                orgId = _corporateList.get(faker.number().numberBetween(0, corporateList.size())).getOrgId();
                System.out.println(" [-->] ...... #ReAttempt ...... Random Org Id :: " +orgId);
            }
            if(type.equals("PGAdmin")) {
                preparePGAdmins(orgId);
            } else if(type.equals("CardHolder")){
                prepareCardHolders(orgId);
            }
            orgIdSet.add(orgId);
        }
    }

    public static List<Corporate> addMetaDataForCorporate(List<Corporate> corporateList) {
        CorporateMetaData metaData = new CorporateMetaData();
        metaData.setTotal(corporateList.size());
        //Corporate corporate = new Corporate();
        Corporate corporate = corporateList.get(corporateList.size()-1);
        corporate.setMetaData(metaData);
        //corporateList.add(corporate);

        return corporateList;
    }

    public static List<CardHolder> addMetadataForCardHolders(List<CardHolder> cardHolderList) {
        CorporateMetaData metaData = new CorporateMetaData();
        metaData.setTotal(cardHolderList.size());
        //Corporate corporate = new Corporate();
        CardHolder cardHolder = cardHolderList.get(cardHolderList.size()-1);
        cardHolder.setMetaData(metaData);
        //corporateList.add(corporate);

        return cardHolderList;
    }

    public static List<ProgramAdmin> addMetadataForPGAdmin(List<ProgramAdmin> pgAdminList) {
        CorporateMetaData metaData = new CorporateMetaData();
        metaData.setTotal(pgAdminList.size());
        //Corporate corporate = new Corporate();
        ProgramAdmin _pgAdmin = pgAdminList.get(pgAdminList.size()-1);
        _pgAdmin.setMetaData(metaData);
        //corporateList.add(corporate);

        return pgAdminList;
    }

    public static void addCardHolder(CardHolder cardHolder) {
        System.out.println("[*] addCustomer invoked...");
        CorpPGAdminUtil.cardHolderList.add(cardHolder);
        List<CardHolder> cardHolderList = CorpPGAdminUtil.cardHolderMap.get(cardHolder.getOrgId());

        if(null==cardHolderList) {
            cardHolderList = new ArrayList<>();
        }

        cardHolderList.add(cardHolder);
        System.out.println(" ...... cardHolderList updated");
        CorpPGAdminUtil.cardHolderMap.put(cardHolder.getOrgId(), cardHolderList);
        System.out.println(" ...... cardHolderMap updated");
    }

    public static Corporate getCorporateByOrgId(String orgId)  {
        return CorpPGAdminUtil.corporateMap.get(orgId);
    }

    public static List<CardHolder> getCardHoldersByOrgId(String orgId)  {
        return CorpPGAdminUtil.cardHolderMap.get(orgId);
    }

    public static List<ProgramAdmin> getPGAdminsByOrgId(String orgId)  {
        return CorpPGAdminUtil.pgAdminMap.get(orgId);
    }
}

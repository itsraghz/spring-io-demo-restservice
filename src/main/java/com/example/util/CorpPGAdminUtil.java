package com.example.util;


import com.example.bo.CardHolder;
import com.example.bo.CorpCards;
import com.example.bo.Corporate;
import com.example.bo.ProgramAdmin;
import com.example.bo.meta.CorporateMetaData;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Data
@EqualsAndHashCode
public class CorpPGAdminUtil {

    public static Map<String, Corporate> corporateMap = new HashMap<>();
    public static List<Corporate> corporateList = new ArrayList<>();
    public static List<CardHolder> cardHolderList = new ArrayList<>();
    public static Map<String, List<CardHolder>> cardHolderListMap = new HashMap<>();
    public static Map<Long, CardHolder> cardHolderMap = new HashMap<>();

    public static List<CorpCards> corpCardsList = new ArrayList<>();
    public static Map<String, Corporate> corpCardsMap = new HashMap<>();

    public static List<ProgramAdmin> pgAdminList = new ArrayList<>();
    public static Map<String, List<ProgramAdmin>> pgAdminListMap = new HashMap<>();
    public static Map<Long, ProgramAdmin> pgAdminMap = new HashMap<>();

    public static final String KEY_BASE = "data.dynamic.metadata";
    public static final String KEY_SEPARATOR = ".";
    public static final String KEY_CORP = KEY_BASE + KEY_SEPARATOR + "corp";
    public static final String KEY_PG_BILLING_ENTITIES = KEY_BASE + KEY_SEPARATOR + "pgBillingEntities";
    public static final String KEY_COUNTRY = KEY_BASE + KEY_SEPARATOR + "country";
    public static final String KEY_PG_ADMIN_TYPE = KEY_BASE + KEY_SEPARATOR + "pgAdminType";
    public static final String KEY_CARD_TYPES = KEY_BASE + KEY_SEPARATOR + "cardTypes";
    public static final String KEY_PG_ACCESS_RIGHTS = KEY_BASE + KEY_SEPARATOR + "pgAccessRights";
    public static final String KEY_YES_NO = KEY_BASE + KEY_SEPARATOR + "yesNo";
    public static final String KEY_CITY = KEY_BASE + KEY_SEPARATOR + "city";
    public static final String KEY_LAST_NAME = KEY_BASE + KEY_SEPARATOR + "lastName";
    public static final String KEY_CARD_STATUS = KEY_BASE + KEY_SEPARATOR + "cardStatus";
    public static final String KEY_PGADMIN_NAMES = KEY_BASE + KEY_SEPARATOR + "pgAdminNames";
    public static final String KEY_FIRST_NAME = KEY_BASE + KEY_SEPARATOR + "firstName";
    public static final String KEY_PGADMIN_STATUS = KEY_BASE + KEY_SEPARATOR + "pgAdminStatus";

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

    /*private static final String[] corpNamesArray = PropertyUtil.getPropArray(KEY_CORP);
    private static final String[] countryNamesArray = PropertyUtil.getPropArray(KEY_COUNTRY);
    private static final String[] cityNamesArray = PropertyUtil.getPropArray(KEY_CITY);
    private static final String[] cardTypeArray = PropertyUtil.getPropArray(KEY_CARD_TYPES);
    private static final String[] yesNoArray = PropertyUtil.getPropArray(KEY_YES_NO);
    private static final String[] cardStatusArray = PropertyUtil.getPropArray(KEY_CARD_STATUS);
    private static final String[] firstNameArray = PropertyUtil.getPropArray(KEY_FIRST_NAME);
    private static final String[] lastNameArray = PropertyUtil.getPropArray(KEY_LAST_NAME);
    private static final String[] pgAdminStatusArray = PropertyUtil.getPropArray(KEY_PGADMIN_STATUS);
    private static final String[] pgAdminTypeArray = PropertyUtil.getPropArray(KEY_PG_ADMIN_TYPE);
    private static final String[] pgAdminNamesArray = PropertyUtil.getPropArray(KEY_PGADMIN_NAMES);
    private static final String[] pgBillingEntityArray = PropertyUtil.getPropArray(KEY_PG_BILLING_ENTITIES);
    private static final String[] pgAccessRightsArray = PropertyUtil.getPropArray(KEY_PG_ACCESS_RIGHTS);*/

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
        Map<String, List<CardHolder>> _cardHolderMap = CorpPGAdminUtil.cardHolderListMap;
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
        Map<String, List<ProgramAdmin>> _pgAdminMap = CorpPGAdminUtil.pgAdminListMap;
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

        CorpPGAdminUtil.cardHolderMap.put(cardHolder.getId(), cardHolder);

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

        CorpPGAdminUtil.cardHolderListMap.put(orgId, cardHolderListTemp);
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
            cardHolderList = CorpPGAdminUtil.cardHolderListMap.get(key);
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

        cardHolderList = CorpPGAdminUtil.cardHolderListMap.get(orgId);
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

        for(int i = 0; i < 6; i++) {
            pgAdmin = createProgramAdmin(orgId);
            programAdminListTemp.add(pgAdmin);
        }

        CorpPGAdminUtil.pgAdminListMap.put(orgId, programAdminListTemp);
        CorpPGAdminUtil.pgAdminList.addAll(programAdminListTemp);
    }

    private static ProgramAdmin createProgramAdmin(String orgId) {
        ProgramAdmin pgAdmin = new ProgramAdmin();
        int randomIndexPGBillingEntity = 0, randomIndexPGAccessRights = 0, randomIndexPGAdminType = 0, randomIndexPGAdminName = 0;

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

        CorpPGAdminUtil.pgAdminMap.put(pgAdmin.getId(), pgAdmin);

        return pgAdmin;
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
        List<CardHolder> cardHolderList = CorpPGAdminUtil.cardHolderListMap.get(cardHolder.getOrgId());

        if(null==cardHolderList) {
            cardHolderList = new ArrayList<>();
        }

        cardHolderList.add(cardHolder);
        System.out.println(" ...... cardHolderList updated");
        CorpPGAdminUtil.cardHolderListMap.put(cardHolder.getOrgId(), cardHolderList);
        System.out.println(" ...... cardHolderMap updated");
    }

    public static Corporate getCorporateByOrgId(String orgId)  {
        return CorpPGAdminUtil.corporateMap.get(orgId);
    }

    public static List<CardHolder> getCardHoldersByOrgId(String orgId)  {
        return CorpPGAdminUtil.cardHolderListMap.get(orgId);
    }

    public static CardHolder getCardHolderById(String id)  {
        return CorpPGAdminUtil.cardHolderMap.get(Long.parseLong(id));
    }

    public static List<ProgramAdmin> getPGAdminsByOrgId(String orgId)  {
        return CorpPGAdminUtil.pgAdminListMap.get(orgId);
    }

    public static ProgramAdmin getPGAdminById(String id)  {
        return CorpPGAdminUtil.pgAdminMap.get(Long.parseLong(id));
    }

    public static void updateCorporate(String orgId, String userName, Corporate corporateParam) {
        System.out.println(" ..... updateCorporate.....");
        if(null!=userName && userName.trim().length()>0) {
            corporateParam.setModifiedBy(userName);
        }

        CorpPGAdminUtil.updateCorporateObj(corporateParam);
    }

    private static void updateCorporateObj(Corporate corporate) {
        final String THIS_METHOD_NAME = "updateCorporateObj() - ";
        List<Corporate> corporateList = CorpPGAdminUtil.corporateList;
        for(int i=0; i < corporateList.size(); i++) {
            Corporate _corporate = corporateList.get(i);
            if(_corporate.getOrgId().equals(corporate.getOrgId())) {
                corporate.update();
                CorpPGAdminUtil.corporateList.remove(i);
                CorpPGAdminUtil.corporateList.add(corporate);
                System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - corporateList updated");
                CorpPGAdminUtil.corporateMap.put(corporate.getOrgId(), corporate);
                System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - corporateMap updated");
                break;
            }
        }
    }

    public static int getMatchingIndexOfAListElement(List<CardHolder> cardHolderList, CardHolder cardHolder) {
        int index = 1;
        for(int i=0; i < cardHolderList.size(); i++) {
            CardHolder _cardHolder = cardHolderList.get(i);
            if(_cardHolder.getId()==cardHolder.getId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void updateCardHolder(String Id, String userName, CardHolder cardHolderParam) {
        System.out.println(" ..... updateCardHolder.....");
        if(null!=userName && userName.trim().length()>0) {
            cardHolderParam.setModifiedBy(userName);
        }

        CorpPGAdminUtil.updateCardHolderObj(cardHolderParam);
    }

    private static void updateCardHolderObj(CardHolder cardHolder) {
        final String THIS_METHOD_NAME = "updateCardHolderObj() - ";

        List<CardHolder> cardHolderList = CorpPGAdminUtil.cardHolderList;
        int index = getMatchingIndexOfAListElement(cardHolderList, cardHolder);
        System.out.println(THIS_METHOD_NAME + "Index of the CardHolderList :: " + index);
        if(index>=0) {
            cardHolder.update();
            CorpPGAdminUtil.cardHolderList.remove(index);
            CorpPGAdminUtil.cardHolderList.add(cardHolder);
            System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - cardHolderList updated");
        }
        List<CardHolder> cardHoldersListForMap = CorpPGAdminUtil.cardHolderListMap.get(cardHolder.getOrgId());
        index = getMatchingIndexOfAListElement(cardHoldersListForMap, cardHolder);
        System.out.println(THIS_METHOD_NAME + "Index of the cardHoldersListForMap :: " + index);
        if(index>=0) {
            cardHoldersListForMap.remove(index);
            cardHoldersListForMap.add(cardHolder);

            CorpPGAdminUtil.cardHolderListMap.put(cardHolder.getOrgId(), cardHoldersListForMap);
            System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - cardHolderMap updated for the orgId :: "+cardHolder.getOrgId());
        }

        CorpPGAdminUtil.cardHolderMap.put(cardHolder.getId(), cardHolder);
        System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - cardHolderMap updated");
    }

    //TODO: Make an Inheritance to avoid this rework (BaseBO)
    public static int getMatchingIndexOfAListElement(List<ProgramAdmin> pgAdminList, ProgramAdmin programAdmin) {
        int index = 1;
        for(int i=0; i < pgAdminList.size(); i++) {
            ProgramAdmin _programAdmin = pgAdminList.get(i);
            if(_programAdmin.getId()==programAdmin.getId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void updatePGAdmin(String Id, String userName, ProgramAdmin programAdminParam) {
        System.out.println(" ..... updatePGAdmin.....");
        if(null!=userName && userName.trim().length()>0) {
            programAdminParam.setModifiedBy(userName);
        }

        CorpPGAdminUtil.updatePGAdminObj(programAdminParam);
    }

    private static void updatePGAdminObj(ProgramAdmin programAdmin) {
        final String THIS_METHOD_NAME = "updatePGAdminObj() - ";

        List<ProgramAdmin> pgAdminList = CorpPGAdminUtil.pgAdminList;
        int index = getMatchingIndexOfAListElement(pgAdminList, programAdmin);
        System.out.println(THIS_METHOD_NAME + "Index of the pgAdminList :: " + index);
        if(index>=0) {
            programAdmin.update();
            CorpPGAdminUtil.pgAdminList.remove(index);
            CorpPGAdminUtil.pgAdminList.add(programAdmin);
            System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - pgAdminList updated");
        }
        List<ProgramAdmin> pgAdminListForMap = CorpPGAdminUtil.pgAdminListMap.get(programAdmin.getOrgId());
        index = getMatchingIndexOfAListElement(pgAdminListForMap, programAdmin);
        System.out.println(THIS_METHOD_NAME + "Index of the pgAdminListForMap :: " + index);
        if(index>=0) {
            pgAdminListForMap.remove(index);
            pgAdminListForMap.add(programAdmin);

            CorpPGAdminUtil.pgAdminListMap.put(programAdmin.getOrgId(), pgAdminListForMap);
            System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - pgAdminListMap updated for the orgId :: "+programAdmin.getOrgId());
        }

        CorpPGAdminUtil.pgAdminMap.put(programAdmin.getId(), programAdmin);
        System.out.println(THIS_METHOD_NAME + "CorpPGAdminUtil - pgAdminMap updated");
    }
}

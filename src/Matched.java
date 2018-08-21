import java.util.*;
import java.util.stream.Stream;


import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;


public class Matched {

    public static void main(String args[]) {


        List<AppleVersion> appleVersions = Arrays.asList(
                new AppleVersion(1234, 111, "", "com.uday.1234"),
                new AppleVersion(2341, 222, "", "com.uday.2341"),
                new AppleVersion(3412, 333, "", "com.uday.3412")

        );

        List<AppleRuntimeBinding> appleRuntimeBindings = Arrays.asList(
                new AppleRuntimeBinding("com.uday.1234", Arrays.asList(new AppleRequest(1234, ""), new AppleRequest(1111, ""))),
                new AppleRuntimeBinding("com.uday.2341", Arrays.asList(new AppleRequest(2341, ""), new AppleRequest(2222, ""))),
                new AppleRuntimeBinding("com.uday.3412", Arrays.asList(new AppleRequest(3412, ""), new AppleRequest(3333, ""))),
                new AppleRuntimeBinding("com.uday.9999", Arrays.asList(new AppleRequest(4444, ""), new AppleRequest(5555, "")))


        );

        List<AppleUnit> appleUnits = Arrays.asList(
                new AppleUnit(111, "", ""),
                new AppleUnit(444, "", "") // Test data for non existing version


        );

        Response response = new Response();

        //group by price
        Map<String, List<AppleWrapper>> appleVersionsGroupByDataset = appleVersions.stream()
                .map(appleVersion -> {
                   AppleWrapper appleWrapper =  new AppleWrapper(appleVersion.getAppleId(),appleVersion.getApple(),appleVersion.getDataset()) ;
                   appleWrapper.setVersionId(appleVersion.getVersionId());

                   return appleWrapper;
                })
                .collect(groupingBy(AppleWrapper::getDataset));
        System.out.println(appleVersionsGroupByDataset);

        //group by price
        // Assume dataset info doesnt exist in the apple info
        Map<String, List<AppleWrapper>> applerequestsGroupedByDataset = appleRuntimeBindings.stream()
                .collect(
                        toMap(it -> it.getDataset(),it -> {
                            List<AppleWrapper>  appleWrappers  =it.getAppleRequestList().stream().map(appleRequest -> {
                                AppleWrapper appleWrapper =  new AppleWrapper(appleRequest.getAppleId(),appleRequest.getApple(),it.getDataset());
                                return appleWrapper;
                            }).collect(toList());
                            return appleWrappers;

                        }));

        System.out.println(applerequestsGroupedByDataset);



        Stream.concat(appleVersionsGroupByDataset.entrySet().stream(), applerequestsGroupedByDataset.entrySet().stream())
                .collect(toMap(it -> it.getKey(), it -> it.getValue(), (v1, v2) -> {

                            List<AppleWrapper> matchedList = new ArrayList<>();
                            List<AppleWrapper> unMatchedList = new ArrayList<>();
                                v1.stream().forEach(version -> {

                                    if (v2.contains(version)) {

                                        matchedList.add(version);
                                        version.verifyCheckSumMatch(v2 .get(v2.indexOf(version)));
                                        if(version.isCheckSumMatched()){
                                            if(appleUnits.contains(version)) {
                                                AppleUnit appleUnit =  appleUnits.get(appleUnits.indexOf(version));
                                                //execute();
                                                //pouplate error and success message
                                            } else {
                                                // no test data exists
                                            }

                                        }

                                } else {
                                        unMatchedList.add(version);
                                    }

                                }) ;
                                return matchedList;
                            }
                        , HashMap::new));
    }
}

class AppleVersion {

    private Integer appleId;

    public Integer getVersionId() {
        return versionId;
    }

    public String getApple() {
        return apple;
    }

    private Integer versionId;
    private String apple;
    private String dataset;

    public String getDataset() {
        return dataset;
    }

    public Integer getAppleId() {
        return appleId;
    }


    public AppleVersion(Integer appleId, Integer versionId, String apple, String dataset) {
        this.appleId = appleId;
        this.versionId = versionId;
        this.apple = apple;
        this.dataset = dataset;
    }
}

class AppleUnit {

    private Integer versionId;
    private String data;
    private String assertion;

    public AppleUnit(Integer versionId, String data, String assertion) {
        this.versionId = versionId;
        this.data = data;
        this.assertion = assertion;
    }
}

class AppleRuntimeBinding {

    private String dataset;

    public String getDataset() {
        return dataset;
    }

    public List<AppleRequest> getAppleRequestList() {
        return appleRequestList;
    }

    private List<AppleRequest> appleRequestList;

    public AppleRuntimeBinding(String dataset, List<AppleRequest> appleRequestList) {
        this.dataset = dataset;
        this.appleRequestList = appleRequestList;
    }

}

class AppleRequest {


    private Integer appleId;
    private String apple;

    public Integer getAppleId() {
        return appleId;
    }

    public String getApple() {
        return apple;
    }

    public AppleRequest(Integer appleId, String apple) {
        this.appleId = appleId;
        this.apple = apple;
    }
}

class AppleWrapper{
    private Integer appleId;
    private Integer versionId;
    private String apple;
    private String dataset;
    private boolean checkSumMatched;
    private String testResult;
    private String errorMessage;

    public AppleWrapper(Integer appleId, String apple, String dataset) {
        this.appleId = appleId;
        this.versionId = versionId;
        this.apple = apple;
        this.dataset = dataset;
    }

    public String getDataset() {
        return dataset;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
    public Integer getAppleId() {
        return appleId;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public String getApple() {
        return apple;
    }
    public boolean isCheckSumMatched() {
        return checkSumMatched;
    }

    public boolean verifyCheckSumMatch(AppleWrapper other) {
       return true;

    }


}

class Response {
    private Map<String,Integer> misMatchMap;

    public void setMisMatchMap(Map<String, Integer> misMatchMap) {
        this.misMatchMap = misMatchMap;
    }
}

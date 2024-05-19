package app.dynamodb;

import app.dynamodb.model.PotholeComplaint;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PotholeComplaintDao {
    private static final int PAGE_SIZE = 25;
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public PotholeComplaintDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public PotholeComplaint getComplaint(String complaintId) {
        return dynamoDBMapper.load(PotholeComplaint.class, complaintId);
    }

    public PotholeComplaint saveComplaint(PotholeComplaint potholeComplaint) {
        dynamoDBMapper.save(potholeComplaint);
        return potholeComplaint;
    }

    public List<PotholeComplaint> getComplaintsForPage(int page) {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        PaginatedScanList<PotholeComplaint> scanList = dynamoDBMapper.scan(PotholeComplaint.class, scanExpression);

        int startIndex = (page - 1) * PAGE_SIZE;
        return scanList.stream()
                .skip(startIndex)
                .limit(PAGE_SIZE)
                .collect(Collectors.toList());
    }
}

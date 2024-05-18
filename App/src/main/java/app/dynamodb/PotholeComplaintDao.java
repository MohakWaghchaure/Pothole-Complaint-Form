package app.dynamodb;

import app.dynamodb.model.PotholeComplaint;
import app.exceptions.ComplaintNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PotholeComplaintDao {

    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public PotholeComplaintDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public PotholeComplaint getComplaint(String complaintId) {
        PotholeComplaint potholeComplaint = this.dynamoDBMapper.load(PotholeComplaint.class, complaintId);
        if (potholeComplaint == null) {
            throw new ComplaintNotFoundException("Complaint not found");
        }

        return potholeComplaint;
    }

    public PotholeComplaint saveComplaint(PotholeComplaint potholeComplaint) throws ComplaintNotFoundException {
        this.dynamoDBMapper.save(potholeComplaint);
        return potholeComplaint;
    }


    public List<PotholeComplaint> getAllComplaints() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        PaginatedScanList<PotholeComplaint> scanList = dynamoDBMapper.scan(PotholeComplaint.class, scanExpression);
        return scanList.stream().collect(Collectors.toList());
    }
}

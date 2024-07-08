package lk.ijse.dto;

public class BillRecordDTO {

    private String billId;
    private String clientId;
    private String date;

    public BillRecordDTO() {
    }

    public BillRecordDTO(String billId, String clientId, String date) {
        this.billId = billId;
        this.clientId = clientId;
        this.date = date;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BillRecord{" +
                "billId='" + billId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

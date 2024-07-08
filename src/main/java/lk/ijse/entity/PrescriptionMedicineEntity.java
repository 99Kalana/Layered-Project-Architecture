package lk.ijse.entity;

public class PrescriptionMedicineEntity {

    private String id;
    private String pId;

    public PrescriptionMedicineEntity() {
    }

    public PrescriptionMedicineEntity(String id, String pId) {
        this.id = id;
        this.pId = pId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "PrescriptionMedicine{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                '}';
    }
}

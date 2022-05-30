package github.fintechecommerce.model;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AllResponsesModel<ResponseData> extends ResponseModel<ResponseData> {

    private int currentPage = 0;
    private int totalPage  = 0;
    private  int totalRecord = 0;
    private int pageSize = 0;
    private String sortBy = "";
    private String sortType = "ASC";
    private boolean filtered = false;

}

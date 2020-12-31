public class SQLService {

    private final RequestSQLManager request;

    enum Queries {
        query_1, query_2, query_3
    }

    public SQLService() {
        this.request = new RequestSQLManager();
    }

    public void getQuery(Queries query) {
        if(query.equals(Queries.query_1)) {
            System.out.println(request.getQuery1());
        }
        if(query.equals(Queries.query_2)) {
            System.out.println(request.getQuery2());
        }
        if(query.equals(Queries.query_3)) {
            System.out.println(request.getQuery3());
        }
    }
}

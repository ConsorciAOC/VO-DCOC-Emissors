package cat.aoc.dcoc.cocref.service;

import org.openuri.CocrefSoap;
import org.openuri.Consulta;
import org.openuri.ConsultaResponse;
import org.openuri.DadesTecniques;
import org.openuri.DadesTecniquesResponse;
import org.openuri.Descarrega;
import org.openuri.DescarregaResponse;

import cat.aoc.dcoc.cocref.Peticio;
import cat.aoc.dcoc.cocref.ProjecteConsulta;
import cat.aoc.dcoc.cocref.RespostaConsulta;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceContext;

@WebService(endpointInterface = "org.openuri.CocrefSoap")
public class DCOCService  implements CocrefSoap {

  @Resource
    private WebServiceContext context;

    @Override
    public ConsultaResponse consulta(Consulta consulta) {
        
        // Set id de projecte
        Peticio peticio = new Peticio();
        peticio.setIdProjecte(consulta.getPeticio().getIdProjecte());
        cat.aoc.dcoc.cocref.Error err = new cat.aoc.dcoc.cocref.Error();
        err.setCodi("0");
        // Set estat visat --> VISAT TELEMATICAMETN
        ProjecteConsulta prjConsulta = new ProjecteConsulta();
        prjConsulta.setEstatVisat("VISAT TELEMATICAMENT");        
        
        // Sets dels blocs anteriors
        RespostaConsulta rc = new RespostaConsulta();
        rc.setProjecte(prjConsulta);
        rc.setPeticio(peticio);
        rc.setError(err);
        
        // Retornem la resposta
        ConsultaResponse cr = new ConsultaResponse();
        cr.setRespostaConsulta(rc);

        return cr;
    }

    @Override
    public DadesTecniquesResponse dadesTecniques(DadesTecniques dadesTecniques) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DescarregaResponse descarrega(Descarrega resposta) {
        // TODO Auto-generated method stub
        return null;
    }

}


/*
  @Override
  public AccountDetailsResponse getAccountDetails(AccountDetailsRequest parameters) {

    ObjectFactory factory = new ObjectFactory();
    AccountDetailsResponse response = factory.createAccountDetailsResponse();

    Account account = factory.createAccount();
    account.setAccountNumber("12345");
    account.setAccountStatus(EnumAccountStatus.ACTIVE);
    account.setAccountName("Joe Bloggs");
    account.setAccountBalance(3400);

    response.setAccountDetails(account);
    return response;
  }
*/

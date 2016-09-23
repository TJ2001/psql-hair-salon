import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  private Client mClient;

  @Before
  public void initialize() {
    mClient = new Client("Emily Bently", "sensitive brown hair", "ebeautiful@gmail.com", "(345)892-7019", 1);
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true(){
    assertEquals(true, mClient instanceof Client);
  }

  @Test
  public void getName_instantiatesWithName_String(){
    assertEquals("Emily Bently", mClient.getName());
  }

  @Test
  public void getDetail_instantiatesWithDetail_String(){
    assertEquals("sensitive brown hair", mClient.getDetail());
  }

  @Test
  public void getEmail_instantiatesWithEmail_String(){
    assertEquals("ebeautiful@gmail.com", mClient.getEmail());
  }

  @Test
  public void getPhoneNumber_instantiatesWithPhoneNumber_String() {
    assertEquals("(345)892-7019", mClient.getPhoneNumber());
  }

  @Test
  public void getId_instantiatesWithID_1(){
    mClient.save();
    assertTrue(mClient.getId() > 0);
  }

  @Test
  public void all_returnsAllinstancesOfClient_true(){
    mClient.save();
    Client secondClient = new Client("Rebecca Lane", "thick red hair", "rlane21@yahoo.com", "(245)989-2311", 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(mClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void clear_emptiesAllClientsFromArrayList_0(){
    assertEquals(0, Client.all().size());
  }

  @Test
  public void find_returnsClientWithSameId_secondClient() {
    mClient.save();
    Client secondClient = new Client("Rebecca Lane", "thick red hair", "rlane21@yahoo.com", "(245)989-2311", 1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfClientsAreTheSame() {
    Client secondClient = new Client("Emily Bently", "sensitive brown hair", "ebeautiful@gmail.com", "(345)892-7019", 1);
    assertTrue(mClient.equals(secondClient));
  }

  @Test
  public void save_returnsTrueIfNamesAreTheSame() {
    mClient.save();
    assertTrue(Client.all().get(0).equals(mClient));
  }

  @Test
  public void save_assignsIdToObject() {
    mClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(mClient.getId(), savedClient.getId());
  }

  @Test
  public void update_updatesClient_true() {
    mClient.save();
    mClient.update("has coloring done recently", "emaculate@mail.com", "(999)999-9999");
    assertEquals("has coloring done recently", Client.find(mClient.getId()).getDetail());
    assertEquals("emaculate@mail.com", Client.find(mClient.getId()).getEmail());
    assertEquals("(999)999-9999", Client.find(mClient.getId()).getPhoneNumber());
  }

  @Test
  public void delete_deletesClient_true() {
    mClient.save();
    int mClientId = mClient.getId();
    mClient.delete();
    assertEquals(null, Client.find(mClientId));
  }
}

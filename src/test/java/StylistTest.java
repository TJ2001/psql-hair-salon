import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {
  private Stylist mStylist;

  @Before
  public void initialize(){
    mStylist = new Stylist("Fei Long", "does an excellent dry cut");
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    assertEquals(true, mStylist instanceof Stylist);
  }

  @Test
  public void Stylist_instantiatesWithArtist_String() {
    assertEquals("Fei Long", mStylist.getArtist());
  }

  @Test
  public void Stylist_instantiatesWithDetail_String() {
    assertEquals("does an excellent dry cut", mStylist.getDetail());
  }

  @Test
  public void Stylist_instantiatesWithID_1() {
    mStylist.save();
    assertTrue(mStylist.getId() > 0);
  }

@Test
 public void find_returnsStylistWithSameId_secondStylist() {
   Stylist secondStylist = new Stylist("Osia", "just fabulous");
   secondStylist.save();
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist secondStylist = new Stylist("Fei Long", "does an excellent dry cut");
    assertTrue(mStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    mStylist.save();
    assertTrue(Stylist.all().get(0).equals(mStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    mStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(mStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getClients_retrievesALlClientsFromDatabase_clientsList() {
    mStylist.save();
    Client firstClient = new Client("Emily Bently", "sensitive brown hair", "ebeautiful@gmail.com", "(345)892-7019", mStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Rebecca Lane", "thick red hair", "rlane21@yahoo.com", "(245)989-2311", mStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(mStylist.getClients().containsAll(Arrays.asList(clients)));
  }
}

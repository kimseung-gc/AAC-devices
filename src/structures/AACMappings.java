package structures;
import java.io.File;
import java.io.FileWriter;

/**
 * AACMapping for the AAC.
 * @author Seunghyeon (Hyeon) Kim
 */

public class AACMappings {

  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Default category
   */
  final static String DEFAULT = "default";

  /**
   * current category that the AACMapping is on.
   */
  AACCategory currentCategory;

  // The associative array for saving the categories
  AssociativeArray<String, AACCategory> map = new AssociativeArray<String, AACCategory>();

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Initializes the AACMappings with default category
   */
  public AACMappings(){
    this.map.set(DEFAULT, new AACCategory(DEFAULT));
    try {
      this.currentCategory = this.map.get(DEFAULT);
    } catch (Exception e) {
      this.currentCategory = new AACCategory(DEFAULT);
    } // try/catch
  } // AACMappings()

  /**
   * Initializes the AACMappings with categoryName
   */
  public AACMappings(String categoryName){
    this.map.set(categoryName, new AACCategory(categoryName));
    try {
      this.currentCategory = this.map.get(categoryName);
    } catch (Exception e) {
      this.currentCategory = new AACCategory(categoryName);
    } // try/catch
  } // AACMappings(String)

  // +----------------+-------------------------------------------------
  // | Public Methods |
  // +----------------+
  /**
   * Adds an item to the current category with key: imageLoc and val: text.
   * @param imageLoc
   * @param text
   */
  public void add(String imageLoc, String text){
    currentCategory.addItem(imageLoc, text);
  } // add(String, String)

  /**
   * Gets the current category name
   * @return
   */
  public String getCurrentCategory(){
    return this.currentCategory.categoryName;
  } // getCurrentCategory()

  /**
   * Gets the image location of the current category
   * @return
   */
  public String[] getImageLocs(){
    return this.currentCategory.getImages();
  } // getImageLocs()

  /**
   * Gets the text associated with the imageLoc in the current category.
   * @param imageLoc
   * @return
   */
  public String getText(String imageLoc){
    try {
      return this.currentCategory.getText(imageLoc);
    } catch (Exception e) {
      return null;
    } // try/catch
  } // getText(String)

  /**
   * Returns whether the vategory with categoryName is present in the map.
   * @param categoryName
   * @return
   */
  public boolean isCategory(String categoryName){
    return this.map.hasKey(categoryName);
  } // isCategory(String)

  /**
   * Resets the map and current category.
   */
  public void reset(){
    /* reset the maps and current category */
    this.map = new AssociativeArray<String, AACCategory>();
    this.currentCategory = new AACCategory(DEFAULT);
  } // reset()

  /**
   * The method saves a txt file with filename to save the map they have.
   * @param filename
   */
  public void writeToFile(String filename){
    for(KVPair<String, AACCategory> each : this.map){
      /* Write each of the mappings to the file */
      writeEachFile(filename, each.value().getImages());
    } // for
  } // writeToFile(String)

  // +----------------+-------------------------------------------------
  // | Private Methods |
  // +----------------+
  /**
   * This is a helper method for writeToFile to save each of the imageLocs
   * of the AACCategory.
   * @param filename
   * @param images
   */
  private void writeEachFile(String filename, String[] images){
    try {
      File savingFile = new File(filename);
      FileWriter savingFileWriter = new FileWriter(savingFile);
      savingFile.createNewFile();
      for(String each : images){
        try {
          savingFileWriter.write(each + " " + this.currentCategory.getText(each) + "\n>");
        } catch (Exception e) {
          
        } // try/catch
      } // for
      savingFileWriter.write("\n");
      savingFileWriter.close();
      
    } catch (Exception e) {
      return;
    } // try/catch
  } // writeEachFile(String, String[])
} // class AACMappings

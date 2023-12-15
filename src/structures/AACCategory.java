package structures;

/**
 * AAC category for the AAC Mapping class.
 * 
 * @author Seunghyeon (Hyeon) Kim
 */

public class AACCategory {

  // Associative array for the image location and its descriptive text.
  AssociativeArray<String, String> map;
  // name of the current category
  String categoryName;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Constructor for AACCategory. Creates a new category for
   * 
   * @param name
   */
  public AACCategory(String name) {
    this.categoryName = name;
    map = new AssociativeArray<String, String>();
  } // AACCategory(String)

  // +----------------+-----------------------------------------------
  // | Public Methods |
  // +----------------+
  /**
   * This method adds an item with key of image location to value of text,
   * and adds it to the AssociativeArray map.
   * 
   * @param imageLoc
   * @param text
   */
  public void addItem(String imageLoc, String text) {
    this.map.set(imageLoc, text);
  } // addItem(String, String)

  /**
   * This method retrieves the name of the category.
   */
  public String getCategory() {
    return this.categoryName;
  }// getCategory()

  /**
   * This method retrieves the image locations of the caregory
   */
  public String[] getImages() {
    int i = 0;
    String temp[] = new String[this.map.size()];
    for (KVPair<String, String> each : this.map) {
      temp[i] = each.key();
      i++;
    } // for
    return temp;
  } // getImages()

  /**
   * The method returns the text description of the image in the category.
   * If none is found, it will return null.
   * 
   * @param imageLoc
   * @return
   */
  public String getText(String imageLoc) throws KeyNotFoundException {
    return this.map.get(imageLoc);
  } // getText(String)

  /**
   * The method returns whether the category contains the image
   * 
   * @param imageLoc
   */
  public boolean hasImage(String imageLoc) {
    return this.map.hasKey(imageLoc);
  } // hasImage(String)
} // class AACCategory
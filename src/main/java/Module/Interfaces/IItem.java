package Module.Interfaces;

class IItem
{
    private String _name = "";
    private String _description = "";

    /**
     * Get the name of the Item
     * @return Contains the name
     */
    public String Name() { return (_name); }
    protected void SetName(String name) { _name = name; }

    /**
     * Get the description of this Item
     * @return Contains the description
     */
    public String Description() { return (_description); }
    protected void SetDescription(String description) { _description = description; }
}

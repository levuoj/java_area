package Module.FB.Reactions;

import Module.Exception.ModuleException;
import Module.FB.FaceBook;
import Module.Interfaces.IActionData;
import Module.Interfaces.IReaction;
import facebook4j.FacebookException;

public class GoogleSearch extends IReaction {

    public GoogleSearch() {
        SetName("Google Search");
        SetDescription("Google Search");
    }

    private FaceBook _facebook;

    public GoogleSearch init(FaceBook facebook) {
        _facebook = facebook;
        return (this);
    }

    public void ReceiveAction(IActionData data) {
        try {
            String s = data.getString();
            s = s.replaceAll(".*:", "");
            s = s.replaceAll(" ", "+");
            _facebook.get_instance().postStatusMessage("http://lmgtfy.com/?t=i&q=" + s);
        } catch (FacebookException e) {
            e.printStackTrace();
        } catch (ModuleException e) {
            e.printStackTrace();
        }
    }

}
package Module.FB.Reactions;

import Module.Exception.ModuleException;
import Module.FB.FaceBook;
import Module.Interfaces.IActionData;
import Module.Interfaces.IReaction;
import facebook4j.FacebookException;

public class PublishStatus extends IReaction {

    public PublishStatus() {
        SetName("Publish Status");
        SetDescription("Publish a status");
    }

    private FaceBook _facebook;

    public PublishStatus init(FaceBook facebook) {
        _facebook = facebook;
        return (this);
    }

    public void ReceiveAction(IActionData data) {
        try {
            _facebook.get_instance().postStatusMessage(data.getString());
        } catch (FacebookException e) {
            e.printStackTrace();
        } catch (ModuleException e) {
            e.printStackTrace();
        }
    }

}
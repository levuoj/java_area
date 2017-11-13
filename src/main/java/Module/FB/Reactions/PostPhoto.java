package Module.FB.Reactions;

import Module.FB.FaceBook;
import Module.Interfaces.IActionData;
import Module.Interfaces.IReaction;
import facebook4j.FacebookException;
import facebook4j.Media;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PostPhoto extends IReaction {

    public PostPhoto() {
        SetName("Post Photo");
        SetDescription("Post a photo");
    }

    private FaceBook _facebook;

    public PostPhoto init(FaceBook facebook) {
        _facebook = facebook;
        return (this);
    }

    public void ReceiveAction(IActionData data) {
        try {
            FileUtils.copyURLToFile(new URL("https://theswisspub.com/wp-content/uploads/2017/07/THE-PHOENIX.jpg"), new File("phoenix.jpg"));
            _facebook.get_instance().postPhoto(new Media(new File("phoenix.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }
}

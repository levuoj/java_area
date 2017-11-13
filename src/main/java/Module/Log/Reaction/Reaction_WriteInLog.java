package Module.Log.Reaction;

import Module.Interfaces.IActionData;
import Module.Interfaces.IReaction;
import Module.Twitter.Reactions.Reaction_TweetSomething;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reaction_WriteInLog extends IReaction {

    private static final Object         Lock = new Object();
    private DateFormat                  time = new SimpleDateFormat("[ss:mm:HH]");
    private DateFormat                  day = new SimpleDateFormat("dd_MM_yyyy");

    public Reaction_WriteInLog() {
        SetName("Reaction_WriteLog");
        SetDescription("Log all the action in a file");
    }

    /**
     * Function treating the action of a IAction
     * @param data The data that contains the info to be transmitted
     */
    public void ReceiveAction(IActionData data) {
        synchronized (Lock) {
            try {
                Date now = new Date();
                PrintWriter writer = new PrintWriter(data.getIAction() + "_" + day.format(now) + "_Log.txt", "UTF-8");
                String str = time.format(now) + " " + data.getDestination() + ": " + data.getString();
                writer.println(str);
                writer.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

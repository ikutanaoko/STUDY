// CollaborativeEditorServlet.java
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@WebServlet("/CollaborativeEditorServlet")
public class CollaborativeEditorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Set<Session> sessions = new HashSet<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // クライアントからのリクエストを処理
        String userId = request.getParameter("userId");
        String editedText = request.getParameter("editedText");

        // セッションを通じて接続中のクライアントにメッセージを送信
        for (Session session : sessions) {
            if (session.isOpen()) {
                session.getBasicRemote().sendText(userId + "," + editedText);
            }
        }

        response.setContentType("text/plain");
        response.getWriter().write("OK");
    }

    @ServerEndpoint("/CollaborativeEditorSocket")
    public static class CollaborativeEditorSocket {

        @OnOpen
        public void onOpen(Session session) {
            // 新しいクライアントが接続されたときの処理
            sessions.add(session);
        }

        @OnMessage
        public void onMessage(String message, Session session) {
            // クライアントからのメッセージを処理
            for (Session s : sessions) {
                if (s.isOpen() && !s.equals(session)) {
                    // 他のクライアントにメッセージを送信
                    try {
                        String mergedText = mergeText(s, message);
                        s.getBasicRemote().sendText(mergedText);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @OnClose
        public void onClose(Session session) {
            // クライアントが切断されたときの処理
            sessions.remove(session);
        }

        private String mergeText(Session session, String incomingMessage) throws IOException {
            // 他のクライアントからのメッセージと、既存のエディタ内容をマージして返す
            String[] parts = incomingMessage.split(",");
            String senderId = parts[0];
            String incomingText = parts[1];

            String existingText = (String) session.getUserProperties().get("editorText");
            if (existingText == null) {
                existingText = "";
            }

            // 単純な文字列連結でマージする例（実際のアプリケーションでは適切なマージロジックを実装するべき）
            String mergedText = existingText + incomingText;
            
            // マージした結果をセッションに保存
            session.getUserProperties().put("editorText", mergedText);

            return mergedText;
        }

        response.sendRedirect(request.getContextPath() + "/index.jsp?error=login_required");

    }
    <%
    String errorMessage = request.getParameter("error");
    if ("login_required".equals(errorMessage)) {
        out.println("<p style=\"color: red;\">Login is required to access this page.</p>");
    }
%>
}


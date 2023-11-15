import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class sample1 {
  public static void main(String[] args) {
    
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォームからのデータを取得
        String postData = request.getParameter("postData");
        int formId = Integer.parseInt(request.getParameter("formId"));

        // DAOを使用してデータベースに新しい投稿を保存
        PostDAO postDAO = new PostDAO();
        postDAO.savePost(postData);

        // DAOを使用して最新の投稿一覧を取得
        List<Post> postList = postDAO.getAllPosts();

        // 投稿一覧をJSONに変換
        String jsonResponse = convertListToJson(postList);

        // レスポンスにJSONデータを設定
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    private String convertListToJson(List<Post> postList) {
        // 投稿一覧をJSONに変換するロジックを実装
        // ここでは簡略化のため未実装
        return "";
    }
}

// Ajaxリクエストを行うJavaScript
function postAndUpdate(formId) {
  var postData = $("#postData" + formId).val();

  $.ajax({
      type: "POST",
      url: "PostServlet",
      data: { postData: postData, formId: formId },
      dataType: "json", // サーバーからの応答の形式をJSONとして指定
      success: function(response) {
          // サーバーからの応答を受けて、特定の要素を更新
          updatePostList(response, formId);
      }
  });
}

// 特定の要素を更新するJavaScript
function updatePostList(postList, formId) {
  // 投稿一覧を表示する部分のIDを指定して更新
  $("#postList" + formId).empty(); // 一旦クリア
  // 投稿一覧を再描画するロジックを実装
  // ここでは簡略化のため未実装
}

// 特定の要素を更新するJavaScript
function updatePostList(postList, formId) {
  // 投稿一覧を表示する部分のIDを指定して更新
  var postListContainer = $("#postList" + formId);
  
  // 一旦クリア
  postListContainer.empty();

  // 投稿一覧を再描画するロジックを実装
  if (postList.length === 0) {
      postListContainer.append("<p>No posts yet.</p>");
  } else {
      var ul = $("<ul>");

      // 投稿一覧をリストアイテムに追加
      for (var i = 0; i < postList.length; i++) {
          var post = postList[i];
          var li = $("<li>").text(post.content);
          ul.append(li);
      }

      postListContainer.append(ul);
  }
}









  }


}
package com.vuanhvu.blog.util;

import com.vuanhvu.blog.entity.Comment;
import com.vuanhvu.blog.entity.Post;
import com.vuanhvu.blog.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MockData {

    public static User getVuUser() {
        User user = new User();
        user.setImgUrl("https://d1vego9xkjklqd.cloudfront.net/image/avartar.jpg");
        user.setUsername("vuva@gmail.com");
        user.setFirstName("Vu");
        user.setLastName("Anh Vu");
        return user;
    }

    public static Post getOnePost() {
        Post post = new Post();
        post.setId(1);
        post.setCategory("Java");
        post.setTitle("Làm thế nào để tạo 1 web server trên AWS");
        post.setBriefContent("Tạo 1 EC2");
        post.setContent("<ul>\n" +
                "    <li>Tạo 1 EC2</li>\n" +
                "</ul>\n" +
                "<ul>\n" +
                "    <li>Để tạo web server cần chạy httpd hoặc l&agrave; d&ugrave;ng ngnix (chọn 1 trong 2), b&agrave;i n&agrave;y d&ugrave;ng nginx</li>\n" +
                "</ul>\n" +
                "<pre><code>sudo yum install httpd\n" +
                "\n" +
                "sudo systemctl enable httpd\n" +
                "\n" +
                "sudo systemctl start httpd\n" +
                "\n" +
                "</code></pre>\n" +
                "<pre><code>sudo amazon-linux-extras install nginx1\n" +
                "\n" +
                "$ sudo systemctl start nginx.service\n" +
                "\n" +
                "$ sudo systemctl stop nginx.service\n" +
                "\n" +
                "$ sudo systemctl restart nginx.service\n" +
                "\n" +
                "</code></pre>\n" +
                "<ul>\n" +
                "    <li>\n" +
                "        <p>Enable port 80 ở Security group (SG) hoặc enable trong l&uacute;c tạo instance.</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "        <p>C&agrave;i đặt java</p>\n" +
                "        <ul>\n" +
                "            <li><code>yum install java-1.8.0-openjdk</code></li>\n" +
                "            <li><code>java -version</code></li>\n" +
                "        </ul>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "        <p>Donwload source code v&agrave; build ra file jar</p>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "        <p>Chạy ứng dụng</p>\n" +
                "        <ul>\n" +
                "            <li><code>java -jar blog-0.0.1-SNAPSHOT.jar</code></li>\n" +
                "        </ul>\n" +
                "    </li>\n" +
                "    <li>\n" +
                "        <p>Th&ecirc;m config ở trong nginx:</p>\n" +
                "        <ul>\n" +
                "            <li><code>/etc/nginx/conf.d/blog.conf</code></li>\n" +
                "            <li>{&nbsp;<p><span style=\"white-space:pre;\">&nbsp; &nbsp;&nbsp;</span>&nbsp; listen 80; listen [::]:80;</p>\n" +
                "                <p><br></p>\n" +
                "                <p>&nbsp; &nbsp; &nbsp; server_name _;</p>\n" +
                "                <p><br></p>\n" +
                "                <p>&nbsp; &nbsp; &nbsp; location / {</p>\n" +
                "                <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;proxy_pass &lt;<a data-fr-linked=\"true\" href=\"http://localhost:8080/>\">http://localhost:8080/&amp;gt</a>;;</p>\n" +
                "                <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;</p>\n" +
                "                <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;proxy_set_header X-Forwarded-Proto $scheme;</p>\n" +
                "                <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;proxy_set_header X-Forwarded-Port $server_port;</p>\n" +
                "                <p><br></p>\n" +
                "                <p>&nbsp; &nbsp; &nbsp; }</p>\n" +
                "                <p><span style=\"white-space:pre;\">&nbsp; &nbsp;&nbsp;</span>}</p>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "    </li>\n" +
                "</ul>");
        post.setImage("images/image_1.jpg");
        post.setCreateDate(new Date());

        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setContent("Chỉ cần làm như trên là thành công");

        post.setCommentOfAuthor(comment1);

        return post;
    }

    public static Post solidPost() {
        Post post = new Post();
        post.setId(3);
        post.setCategory("Java");
        post.setTitle("SOLID");
        post.setBriefContent("Solid là nguyên tắc thiết kế");
        post.setContent("<h1>Single responsibility principle</h1>\n" +
                "<p>1 class chỉ c&oacute; 1 nhiệm vụ duy nhất.</p>\n" +
                "<h1>Open-close principle</h1>\n" +
                "<ul>\n" +
                "<li>C&oacute; thể mở rộng thoải m&aacute;i t&iacute;nh năng nhưng kh&ocirc;ng sửa class cũ.</li>\n" +
                "<li>Y&ecirc;u cầu viết 1 h&agrave;m lọc theo ti&ecirc;u ch&iacute; m&agrave;u sắc, v&agrave; k&iacute;ch thước\n" +
                "<ul>\n" +
                "<li>\n" +
                "<p>Viết 1 interface Specification c&oacute; h&agrave;m kiểm tra thỏa m&atilde;n</p>\n" +
                "<ul>\n" +
                "<li>Viết 1 class SizeSpecification kế thừa</li>\n" +
                "<li>Vi&ecirc;t 1 class ColorSpecication kế thừa</li>\n" +
                "</ul>\n" +
                "<pre><code class=\"language-lua\">interface Specification&lt;T&gt;\n" +
                "{\n" +
                "  boolean isSatisfied(T item);\n" +
                "}\n" +
                "\n" +
                "class ColorSpecification implements Specification&lt;Product&gt;\n" +
                "{\n" +
                "  private Color color;\n" +
                "\n" +
                "  public ColorSpecification(Color color) {\n" +
                "    this.color = color;\n" +
                "  }\n" +
                "\n" +
                "  @Override\n" +
                "  public boolean isSatisfied(Product p) {\n" +
                "    return p.color == color;\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "class SizeSpecification implements Specification&lt;Product&gt;\n" +
                "{\n" +
                "  private Size size;\n" +
                "\n" +
                "  public SizeSpecification(Size size) {\n" +
                "    this.size = size;\n" +
                "  }\n" +
                "\n" +
                "  @Override\n" +
                "  public boolean isSatisfied(Product p) {\n" +
                "    return p.size == size;\n" +
                "  }\n" +
                "}\n" +
                "</code></pre>\n" +
                "</li>\n" +
                "<li>\n" +
                "<p>Viết 1 interface Filter ( đầu v&agrave;o l&agrave; list v&agrave; interface Specification)</p>\n" +
                "<ul>\n" +
                "<li>Viết 1 class BetterFilter kế thừa</li>\n" +
                "</ul>\n" +
                "<pre><code class=\"language-lua\">interface Filter&lt;T&gt;\n" +
                "{\n" +
                "  Stream&lt;T&gt; filter(List&lt;T&gt; items, Specification&lt;T&gt; spec);\n" +
                "}\n" +
                "\n" +
                "class BetterFilter implements Filter&lt;Product&gt;\n" +
                "{\n" +
                "  @Override\n" +
                "  public Stream&lt;Product&gt; filter(List&lt;Product&gt; items, Specification&lt;Product&gt; spec) \n" +
                "  {\n" +
                "    return items.stream().filter(p -&gt; spec.isSatisfied(p));\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "Main:\n" +
                "BetterFilter bf = new BetterFilter();\n" +
                "\n" +
                "bf.filter(products, new ColorSpecification(Color.GREEN))\n" +
                ".forEach(p -&gt; System.out.println(\" - \" + [p.name](&lt;http://p.name/&gt;) + \" is green\"));\n" +
                "</code></pre>\n" +
                "</li>\n" +
                "</ul>\n" +
                "</li>\n" +
                "</ul>\n" +
                "<h1>Liskov Substitution principle</h1>\n" +
                "<p>Phải đảm bảo lấy thằng con thay thằng cha nhưng chương tr&igrave;nh vẫn chạy đ&uacute;ng.</p>\n" +
                "<h1>Interface Segregation principle</h1>\n" +
                "<p>N&ecirc;n chia 1 interface th&agrave;nh c&aacute;c interface nhỏ, client kh&ocirc;ng n&ecirc;n phụ thuộc nhiều v&agrave;o interface m&agrave; n&oacute; kh&ocirc;ng sử dụng</p>\n" +
                "<h1>Dependency Inversion principle</h1>\n" +
                "<ul>\n" +
                "<li>Module cấp cao kh&ocirc;ng n&ecirc;n phụ thuộc v&agrave;o module cấp thấp</li>\n" +
                "<li>Abstraction kh&ocirc;ng n&ecirc;n phụ thuộc v&agrave;o chi tiết v&agrave; ngược lại</li>\n" +
                "</ul>");
        post.setImage("images/image_2.jpg");
        post.setCreateDate(new Date());

        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setContent("Chỉ cần làm như trên là thành công");

        post.setCommentOfAuthor(comment1);

        return post;
    }

    public static List<Post> generateListPost() {
        List<Post> postList = new ArrayList<>();
        postList.add(getOnePost());
        postList.add(solidPost());
        return postList;
    }

    public static List<Comment> getListCommentOfBlog() {
        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setContent("Đọc không hiểu gì cả");
        comment1.setUser(getVuUser());
        comment1.setCreateDatetime(new Date());


        Comment comment3 = new Comment();
        comment3.setId(3);
        comment3.setContent("Hỏi thằng nào làm mới hiểu");
        comment3.setParentCommentId(2);
        comment3.setUser(getVuUser());
        comment3.setCreateDatetime(new Date());

        Comment comment2 = new Comment();
        comment2.setId(2);
        comment2.setContent("Tôi cũng không hiểu");
        List<Comment> comments1 = new ArrayList<>();
        comments1.add(comment3);
        comment2.setListChildComment(comments1);
        comment2.setUser(getVuUser());
        comment2.setCreateDatetime(new Date());

        comments.add(comment1);
        comments.add(comment2);

        return comments;
    }

    public static Post getPostTravel2019() {
        Post post = new Post();
        post.setId(1);
        post.setCategory("Travel");
        post.setTitle("Năm đầu tiên - 2019");
//        post.setBriefContent("Tạo 1 EC2");
        post.setContent(" <p>Được dẫn đi chơi ở trung tâm thành phố - Lima central, cảm thấy sao mà đường phố sạch\n" +
                "                                thế, không có rác\n" +
                "                                luôn. Sau đó là lần đầu tiên uống Pisco sour, nói chung\n" +
                "                                là mình không hợp khẩu vị với pisco, nhưng cũng là một món nên thử</p>\n" +
                "\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-6\">\n" +
                "                                    <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/street.jpg\" alt=\"\"\n" +
                "                                         class=\"img-fluid\"/>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-6\">\n" +
                "                                    <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/pisco_sour.jpg\" alt=\"\"\n" +
                "                                         class=\"img-fluid\"/>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "\n" +
                "\n" +
                "                            <p><br>Phía ngoài nhà thờ ở Lima central</p>\n" +
                "\n" +
                "\n" +
                "                            <p>\n" +
                "                                <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/temple_lima_centero.jpg\"\n" +
                "                                     alt=\"\"\n" +
                "                                     class=\"img-fluid\"/>\n" +
                "                            </p>\n" +
                "                            <p>Bên trong là nhà thờ rất hoành tráng</p>\n" +
                "                            <p>\n" +
                "                                <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/temple_inside.jpg\" alt=\"\"\n" +
                "                                     class=\"img-fluid\"/>\n" +
                "                            </p>\n" +
                "                            <p>Thành phố Lima về đêm</p>\n" +
                "                            <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/lima_at_night.jpg\" alt=\"\"\n" +
                "                                 class=\"img-fluid\"/>\n" +
                "                            <h2 class=\"mb-3 mt-5\">#Lần đầu rời khỏi Lima</h2>\n" +
                "                            <p>Nằm cách thành phố biển Ica 4 km là ốc đảo Huacachina. Theo truyền thuyết cổ, Huacay\n" +
                "                                China, một cô gái xinh đẹp trong vùng, đang\n" +
                "                                tắm tiên dưới hồ nước thì bị một chàng thợ săn trẻ phát hiện. Nàng Huacay bỏ chạy khi\n" +
                "                                thấy bóng người lạ trong tấm gương soi. Gương vỡ tan biến thành đầm phá, vạt áo dài bung\n" +
                "                                bay, rớt lại phía sau hóa những đụn cát khổng lồ bao quanh. Cô gái liền lặn xuống nước\n" +
                "                                sâu để trốn người lạ mặt.</p>\n" +
                "                            <p>\n" +
                "                                <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/huacachina.jpg\" alt=\"\"\n" +
                "                                     class=\"img-fluid\"/>\n" +
                "                                <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/trip.jpg\" alt=\"\"\n" +
                "                                     class=\"img-fluid\"/>\n" +
                "                            </p>\n" +
                "                            <p><br>Hallowen đi chơi ở công viên mèo, rồi giáng sinh. Lần đầu tiên chơi Secret Santa (mọi\n" +
                "                                người được bốc thăm để tặng những món quà cho nhau vào dịp giáng sinh mà không được để\n" +
                "                                người được tặng biết là ai)</p>\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-6\">\n" +
                "                                    <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/hallowen.jpg\" alt=\"\"\n" +
                "                                         class=\"img-fluid\"/>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-6\">\n" +
                "                                    <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/secet-santa.jpg\" alt=\"\"\n" +
                "                                         class=\"img-fluid\"/>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <p>\n" +
                "                                <br>\n" +
                "                                Sang nhà 1 người bạn trong công ty vào dịp giáng sinh\n" +
                "                            </p>\n" +
                "\n" +
                "                            <img src=\"https://d1vego9xkjklqd.cloudfront.net/image/2019/small-party.jpg\" alt=\"\"\n" +
                "                                 class=\"img-fluid\"/>");
        post.setImage("images/image_1.jpg");
        post.setCreateDate(new Date());

        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setContent("Vậy là kết thúc năm đầu tiên, kỉ niệm ko nhiều lắm nhưng có rất nhiều điều lần đầu tiên được thử");


        post.setCommentOfAuthor(comment1);

        return post;
    }

}

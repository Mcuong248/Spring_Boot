<b>Câu 1 : Trong quá trình tạo dự án Spring Boot chúng ta phải khai báo những tham số sau đây : groupID, artifactID. Ý nghĩa các tham số này là gì?</b> <br> 
 - GroupId là id của nhóm dự án. Nói chung, nó là duy nhất trong một tổ chức<br>
 - ArtifactId là id của dự án. Nó chỉ định tên của dự án. Một phần của tệp XML<br>
<b>Câu 2 : Tại sao phải đảo ngược tên miền trong <groupId>vn.techmaster</groupId>?</b> <br>
- Việc đảo ngược tên miền trong groupId giúp chúng ta nhóm các modul của dự án dễ dàng hơn
- Theo quy định groupId phải tuân theo các quy tắc tên gói (Java’s package name rules) của Java. Điều này có nghĩa là nó bắt đầu với một tên miền đảo ngược.
- Mục đích là tạo ra được tên định danh duy nhất và tạo ra quy tắc chung cho cách đặt tên, tư duy đặt tên đi từ quy mô lớn đến nhỏ cũng giống như khi đặt tên package name<br>
<b>Câu 3 : SpringBoot có 2 cơ chế để quản lý thư viện. Hãy kể tên chúng?</b><br>
- Quản lý bằng maven sử dụng dependency trong file pom
- Quản lý thư viện bằng Gradle<br>
<b> Câu 4 : File pom.xml có tác dụng gì?</b><br>
- xml là nơi khai báo tất cả những gì liên quan đến dự án được cấu hình qua maven, như khai báo các dependency, version của dự án, tên dự án, repossitory… <br>
<b> Câu 5 : Trong file pom.xml có các thẻ dependency. Ý nghĩa của chúng là gì?</b> <br>
- dependency cung cấp tất cả các phụ thuộc và cấu hình tự động cần thiết để phát triển các ứng dụng web.<br>
<b> Câu 6 : Ý nghĩa của @Controllerlà gì?</b><br>
- @Controller để xử lý các request đến server.<br>
<b> Câu 7 : Ý nghĩa của @RequestMapping là gì? Nó có những tham số gì ngoài value?</b><br>
- @RequestMapping ánh xạ các HTTP request tới các phương thức xử lý của MVC và REST controller.
- Ngoài Value còn có method , param , produces example : @RequestMapping(value = "/ex/foos", headers = "key=val", method = GET,produces = MediaType.APPLICATION_XML_VALUE)
- @RequestMapping ngoài được sử dụng để map request với method xử lý request đó, thì cũng có thể map request với class xử lý request đó nữa.<br>
<b> Câu 8 : Ý nghĩa của @RequestBody khi đặt trong hàm hứng request để làm gì?</b><br>
- @RequestBody được dùng để ánh xạ HttpRequest body sang một domain object tự động. <br>
<b> Câu 9 : Hãy trả lời khi nào thì dùng @PathVariable và khi nào nên dùng @RequestParam </b> <br>
- @RequestParam và @PathVariable annotation đều được sử dụng để trích xuất dữ liệu từ request URL
- @RequestParam được dùng để trích xuất dữ liệu từ request query và có 4 tham số hỗ trợ : +)defaultValue : Đây là giá trị mặc định nếu như giá trị của parameters trên URL rỗng. +)name : tên của parameters binding +)required : Cho biết tham số này là có bắt buộc hay không, nếu "required=true" thì thiếu parameters đó request sẽ fail. +)value : đây là alias cho tên của thuộc tính
- @PathVariable thì được dùng để trích xuất dữ liệu từ URL path.
- @PathVariable thì nằm trong dấu xược(/_/) còn @RequestParam thì nằm trong dấu hỏi(?a=x && b=y)
- @PathVariable phải sắp xếp theo thứ tự còn @RequestParam thì không <br>
<b> Câu 10 : Thứ tự các thành phần đường dẫn @PathVariable có thể hoán đổi được không?</b><br>
- Không hoán đổi được phải theo thứ tự <br>
<b> Câu 11 : @GetMapping khác gì so với @PostMapping?</b><br> 
- @GetMapping là ánh xạ đến HTTP request có method GET
- @PostMapiing là ánh xạ đên HTTP request có method POST<br>
<b> Câu 12 : Trong các annotation @RequestMapping, @GetMapping, @PostMapping… có tham số produces = MediaType.XXXX ý nghĩa tham số này là gì?</b><br>
- Định dạng dữ liệu trả về response.Content_Type<br>
<b> Câu 13 : Giải thích ý nghĩa của @RequestBody trong đoạn code dưới đây</b><br>
- @Requestbody giúp ta gửi dữ liệu dưới dạng body Json lên sever<br>
<b> Câu 14 : Cổng mặc định ứng dụng SpringBoot là 8080. Hãy google cách để thay đổi cổng lắng nghe mặc định </b><br>
- Vào file application.properties thay đổi port ex : server.port=8081

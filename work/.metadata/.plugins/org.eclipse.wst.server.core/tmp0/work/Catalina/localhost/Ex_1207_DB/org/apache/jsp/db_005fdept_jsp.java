/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2021-12-09 09:49:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vo.DeptVo;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public final class db_005fdept_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.naming.InitialContext");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("javax.sql.DataSource");
    _jspx_imports_classes.add("vo.DeptVo");
    _jspx_imports_classes.add("javax.naming.Context");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

//JNDI검색을 위한 준비
	InitialContext ic = new InitialContext();
	
	//Resource(참조파일)
	Context ctx = (Context)ic.lookup("java:comp/env");
	
	//찾아낸 JNDI에서 Resource영역에 지정해둔 name속성값을 가져온다.
	DataSource dataSource = (DataSource) ctx.lookup("jdbc/oracle_test");
	
	//DB에 연결 시도하기
	Connection conn = dataSource.getConnection();
	
	System.out.println("--연결성공--");
	
	//sql문장
	String sql = "select * from dept";
	
	//DB에 쿼리 요청
	PreparedStatement ps = conn.prepareStatement(sql);
	
	//쿼리문을 수행하여 결과를 받아온다.
	ResultSet rs = ps.executeQuery();
	
	//부서의 모든 목록을 저장할 Arraylist
	ArrayList<DeptVo> dt= new ArrayList();
	
	//DB의 모든 행을 순회하며 데이터를 가져온다.
	while(rs.next()){
		//현재 rs가 자리잡고 있는 해 위치의 실제 데이터들을 vo에 저장
		DeptVo vo =new DeptVo();
		vo.setDeptno(rs.getInt("deptno"));
		vo.setDname(rs.getString("dname"));
		vo.setLoc(rs.getString("LOC"));
		dt.add(vo);
	}
	
	//DB연결 및 접근에 사용하
	rs.close();
	ps.close();
	
	//DB사용 후 계속 머물러 있으면 11번째 사용자가 접속하지 못하므로
	//DB사용 후 빠져나가도록 연결을 해제
	conn.close();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function send(no){\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		location.href = \"db_sawon.jsp?deptno=\"+no;\r\n");
      out.write("		\r\n");
      out.write(" 	}\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<table border = \"1\">\r\n");
      out.write("	<caption style=\"font-weight :bold\">부서목록</caption>\r\n");
      out.write("		<tr>\r\n");
      out.write("			 <th>부서번호</th>\r\n");
      out.write("			 <th>부서이름</th>\r\n");
      out.write("			 <th>부서위치</th>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");

		for(int i=0;i<dt.size();i++){ 
				DeptVo vo = dt.get(i);
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>");
      out.print(vo.getDeptno() );
      out.write("</td>\r\n");
      out.write("			<td>\r\n");
      out.write("			\r\n");
      out.write("				<a href=\"javascript:send('");
      out.print(vo.getDeptno() );
      out.write("');\">\r\n");
      out.write("					");
      out.print(vo.getDname());
      out.write("\r\n");
      out.write("				</a>\r\n");
      out.write("			</td>\r\n");
      out.write("			<td>");
      out.print(vo.getLoc() );
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("	</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
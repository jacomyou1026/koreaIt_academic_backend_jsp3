/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2022-01-17 15:58:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/전유진/Desktop/학원/web3_pm_jsp/apache-tomcat-8.5.73/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("file:/C:/Users/전유진/Desktop/학원/web3_pm_jsp/apache-tomcat-8.5.73/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1636546476000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<!-- Ajax사용을 위한  httpReques등록-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/httpRequest.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/* 게시글 삭제 */\r\n");
      out.write("function del(){\r\n");
      out.write("	\r\n");
      out.write("	if(!confirm(\"삭제 하시겠습니까?\")){\r\n");
      out.write("		return;\r\n");
      out.write("	}\r\n");
      out.write("	var f = document.ff;\r\n");
      out.write("	\r\n");
      out.write("	//지우고 싶어 입력받은 비번\r\n");
      out.write("	var c_pwd = f.c_pwd.value.trim();\r\n");
      out.write("	\r\n");
      out.write("	if(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.pwd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" != c_pwd){\r\n");
      out.write("		alert(\"비밀번호가 틀립니다.\");\r\n");
      out.write("		alert(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.pwd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(");\r\n");
      out.write("		return;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	var url =\"del.do\";\r\n");
      out.write("	var param =\"idx=\"+");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.idx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("	sendRequest(url,param,delResult,\"POST\");\r\n");
      out.write("}\r\n");
      out.write("	\r\n");
      out.write("	function delResult(){\r\n");
      out.write("		if(xhr.readyState ==4 && xhr.status ==200){\r\n");
      out.write("			var data = xhr.responseText;\r\n");
      out.write("			if(data ==1){\r\n");
      out.write("				alert('삭제 성공');\r\n");
      out.write("				\r\n");
      out.write("			}else{\r\n");
      out.write("				alert('삭제 실패, 관리자에게 문의하세요');\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			location.href='list.do?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("		}	\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function reply() {\r\n");
      out.write("		var f = document.ff;\r\n");
      out.write("		f.action = \"board_reply.jsp\";\r\n");
      out.write("		f.submit();\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<form name=\"ff\" method=\"post\">\r\n");
      out.write("		<table border=\"1\" width=\"700\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"120\">제목</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.subject }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"120\">작성자</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"120\">작성일</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.regdate  }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"120\">내용</th>\r\n");
      out.write("				<td width=\"500\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.content  }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width=\"120\">ip</th>\r\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.ip}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<!-- 비밀번호 -->\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td width=\"120\">비밀번호</td>\r\n");
      out.write("				<td><input type=\"password\" name=\"c_pwd\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"2\">\r\n");
      out.write("					<!-- 목록으로 돌아가기--> \r\n");
      out.write("					<img alt=\"\" src=\"img/btn_list.gif\"\r\n");
      out.write("					onclick=\"location.href='list.do?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\"> \r\n");
      out.write("					\r\n");
      out.write("					<!-- 댓글 달기 --> \r\n");
      out.write("					");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("					 \r\n");
      out.write("					<!-- 글 삭제 --> \r\n");
      out.write("					<img alt=\"\" src=\"img/btn_delete.gif\"\r\n");
      out.write("					onclick=\"del();\">\r\n");
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("		<!--board_reply.jsp?idx=12&page=4  -->\r\n");
      out.write("		<input type=\"hidden\" name=\"idx\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.idx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("		<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("		\r\n");
      out.write("	</form>\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /view.jsp(93,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.depth eq 0}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("						<img alt=\"\" src=\"img/btn_reply.gif\" onclick=\"reply();\">\r\n");
          out.write("					");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}

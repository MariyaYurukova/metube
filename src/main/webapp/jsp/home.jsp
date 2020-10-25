<%@ page import="metube.domain.models.view.TubeDetailsViewModel" %>
<%@ page import="java.util.List" %>
<%@ page import="metube.domain.models.view.TubeThumbnailViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<% List<TubeThumbnailViewModel> tubes = (List<TubeThumbnailViewModel>) request.getAttribute("model"); %>
<div class="container-fluid">
    <header>
        <c:import url="templates/navbar.jsp"/>
    </header>
    <main>
        <hr class="my-3"/>
        <div class="jumbotron">
            <p class="h1 display-3">Welcome, <%= request.getSession().getAttribute("username")%>
            </p>
        </div>
        <div class="container">
            <div class="row text-center">
                <% for (TubeThumbnailViewModel tube : tubes) {%>
                <div class="m-2 justify-content-center width-30p">
                    <div>
                        <a href="/tube/details/<%= tube.getId()%>">
                        <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/<%=tube.getYoutubeId()%>" allowfullscreen
                                frameborder="0"></iframe>
                        </a>
                    </div>
                    <h5 class="text-center"><%= tube.getTitle()%>
                    </h5>
                    <p class="text-center font-italic"><%= tube.getAuthor()%>
                    </p>
                </div>
                <%}%>
            </div>
        </div>

    </main>
    <footer>
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
</body>
</html>
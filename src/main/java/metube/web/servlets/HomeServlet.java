package metube.web.servlets;

import metube.domain.models.view.TubeThumbnailViewModel;
import metube.service.TubeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final TubeService tubeService;


    @Inject
    public HomeServlet(TubeService tubeService) {
        this.tubeService = tubeService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TubeThumbnailViewModel> tubes = tubeService
                .findAllTubes(TubeThumbnailViewModel.class);

        req.setAttribute("model", tubes);


        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }
}

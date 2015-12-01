package demo;

import gribbit.http.request.Request;
import gribbit.http.request.handler.HttpRequestHandler;
import gribbit.http.response.FileResponse;
import gribbit.http.response.Response;
import gribbit.http.response.HTMLResponse;
import gribbit.http.response.exception.ResponseException;
import gribbit.http.server.GribbitHttpServer;

public class GribbitHttpTest {
    public static void main(String[] args) {
        new GribbitHttpServer() //
        .addHttpRequestHandler(new HttpRequestHandler() {
            @Override
            public Response handle(Request request) throws ResponseException {
                if (request.getURL().equals("/")) {
                    return new HTMLResponse(request, "<html><body><p>Request URL: " + request.getURL()
                            + "</p><img src=\"/frog.jpg\">");
                } else {
                    return null;
                }
            }
        }) //
        .addHttpRequestHandler(new HttpRequestHandler() {
            @Override
            public Response handle(Request request) throws ResponseException {
                if (request.getURL().equals("/frog.jpg")) {
                    return new FileResponse(request, GribbitHttpTest.class.getClassLoader()
                            .getResource("demo/frog.jpg").getPath());
                } else {
                    return null;
                }
            }
        }) //
        .start();
    }
}

/**
 * This file is part of the Gribbit Web Framework.
 * 
 *     https://github.com/lukehutch/gribbit
 * 
 * @author Luke Hutchison
 * 
 * --
 * 
 * @license Apache 2.0 
 * 
 * Copyright 2015 Luke Hutchison
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gribbit.http.request.handler;

import gribbit.http.response.exception.ResponseException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public interface WebSocketHandler {
    /** Handle a text websocket frame. If you want to send a response, call ctx.WriteAndFlush(responseWebSocketFrame). */
    public void handleTextFrame(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws ResponseException;

    /** Handle a text websocket frame. If you want to send a response, call ctx.WriteAndFlush(responseWebSocketFrame). */
    public void handleBinaryFrame(ChannelHandlerContext ctx, BinaryWebSocketFrame frame) throws ResponseException;
    
    /** Return true if the passed URL matches a websocket path. */
    public boolean isWebSocketUpgradeURL(String url);
    
    /** Called when the websocket is closed */
    public void close();
}

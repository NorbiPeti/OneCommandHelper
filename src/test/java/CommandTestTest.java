import io.github.norbipeti.onecommandhelper.Commands;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CommandBlock;
import org.bukkit.entity.Player;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CommandTestTest { //Nope. See below.
    @Test
    public void test() {
        /*Bukkit.setServer(Mockito.mock(Server.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                if (is(invocationOnMock, String.class))
                    return "test";
                if (is(invocationOnMock, Logger.class))
                    return Logger.getLogger("Test");
                if (invocationOnMock.getMethod().getName().equals("sendMessage")) {
                    System.out.println(Arrays.toString(invocationOnMock.getArguments()));
                    return null;
                }
                if (!Modifier.isAbstract(invocationOnMock.getMethod().getModifiers()))
                    return invocationOnMock.callRealMethod();
                return null;
            }
        }));
        Commands cmds = new Commands();
        cmds.onCommand(Mockito.mock(Player.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                if (is(invocationOnMock, boolean.class))
                    return true;
                if (is(invocationOnMock, Block.class))
                    return Mockito.mock(Block.class, new Answer() {
                        @Override
                        public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                            if (is(invocationOnMock, Material.class))
                                return Material.COMMAND;
                            if (is(invocationOnMock, BlockState.class))
                                return Mockito.mock(CommandBlock.class);
                            return null; //Nope. The help topics would need to be added too.
                        }
                    });
                System.out.println(invocationOnMock.getMethod().getName());
                System.out.println(Arrays.toString(invocationOnMock.getArguments()));
                return null;
            }
        }), null, "occ", new String[]{});*/
    }

    private <T> boolean is(InvocationOnMock invocationOnMock, Class<T> cl) {
        return invocationOnMock.getMethod().getReturnType().isAssignableFrom(cl);
    }
}
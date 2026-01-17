package net.capy.exampleplugin;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import java.util.logging.Level;

/**
 * Provides access to the various registries used by the framework.
 *
 * <p>These registries allow plugins and modules to register listeners,
 * commands, entities, assets, and persistent data components.</p>
 *
 * <ul>
 *   <li>{@link #getEventRegistry()} – Register event listeners</li>
 *   <li>{@link #getCommandRegistry()} – Register commands</li>
 *   <li>{@link #getEntityRegistry()} – Register custom entities</li>
 *   <li>{@link #getBlockStateRegistry()} – Register block states</li>
 *   <li>{@link #getTaskRegistry()} – Schedule tasks</li>
 *   <li>{@link #getAssetRegistry()} – Register assets</li>
 *   <li>{@link #getEntityStoreRegistry()} – Register entity components</li>
 *   <li>{@link #getChunkStoreRegistry()} – Register chunk components</li>
 * </ul>
 */
public class ExamplePlugin extends JavaPlugin {
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    /**
     * Instantiates a new Example plugin.
     * @param init the init
     */
    public ExamplePlugin(JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from %s version %s", this.getName(), this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        // Called during plugin initialization
        // Register configs, prepare resources
        this.getCommandRegistry().registerCommand(new ExampleCommand(this.getName(), this.getManifest().getVersion().toString()));
    }

    @Override
    public void start() {
        // Called when the plugin starts
        // Register commands, events, entities
        getLogger().at(Level.INFO).log("MyPlugin has started!");
    }

    @Override
    public void shutdown() {
        // Called when the plugin is stopping
        // Clean up resources
        getLogger().at(Level.INFO).log("MyPlugin is shutting down!");
    }
}

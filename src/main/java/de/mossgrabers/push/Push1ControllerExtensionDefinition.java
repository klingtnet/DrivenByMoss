// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.push;

import com.bitwig.extension.api.PlatformType;
import com.bitwig.extension.controller.AutoDetectionMidiPortNamesList;
import com.bitwig.extension.controller.ControllerExtension;
import com.bitwig.extension.controller.api.ControllerHost;

import java.util.UUID;


/**
 * Definition class for the Push 1 extension.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class Push1ControllerExtensionDefinition extends PushControllerExtensionDefinition
{
    private static final UUID EXTENSION_ID = UUID.fromString ("DBED9610-C474-11E6-9598-0800200C9A66");


    /** {@inheritDoc} */
    @Override
    public String getHardwareModel ()
    {
        return "Push 1";
    }


    /** {@inheritDoc} */
    @Override
    public UUID getId ()
    {
        return EXTENSION_ID;
    }


    /** {@inheritDoc} */
    @Override
    public void listAutoDetectionMidiPortNames (final AutoDetectionMidiPortNamesList list, final PlatformType platformType)
    {
        switch (platformType)
        {
            case WINDOWS:
                this.addDeviceDiscoveryPair ("MIDIIN2 (Ableton Push)", "MIDIOUT2 (Ableton Push)", list);
                break;

            case LINUX:
                this.addDeviceDiscoveryPair ("Ableton Push MIDI 2", list);
                break;

            case MAC:
                this.addDeviceDiscoveryPair ("Ableton Push User Port", list);
                break;
        }
    }


    /** {@inheritDoc} */
    @Override
    public ControllerExtension createInstance (final ControllerHost host)
    {
        return new PushControllerExtension (this, host, false);
    }
}

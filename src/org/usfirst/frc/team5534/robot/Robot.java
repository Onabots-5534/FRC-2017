package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	@Override
	public void robotInit()          { Onabot.Init();         }
	
	@Override
	public void robotPeriodic()      { Onabot.Periodic();     }
	
	
	@Override
	public void autonomousInit()     { Autonomous.Init();     }
	
	@Override
	public void autonomousPeriodic() { Autonomous.Periodic(); }
	
	
	@Override
	public void teleopInit()         { Operator.Init();       }
	
	@Override
	public void teleopPeriodic()     { Operator.Periodic();   }
	
	
	@Override
	public void disabledInit()       { Disabled.Init();       }
	
	@Override
	public void disabledPeriodic()   { Disabled.Periodic();   }
	
	
	@Override
	public void testInit()           { Test.Init();           }
	
	@Override
	public void testPeriodic()       { Test.Periodic();       }
		
}


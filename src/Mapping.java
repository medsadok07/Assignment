import java.util.ArrayList;

public class Mapping {
	static Property hasDescription = new StringProperty("hasDescription", "");// =
																				// new
																				// Property();
	static Property hasName = new StringProperty("hasName", "");
	static Property hasTarget = new BpmoProperty("hasTarget", null);
	static Property hasSource = new BpmoProperty("hasSource", null);
	static Property hasHomeProcess = new BpmoProperty("hasHomeProcess", null);
	static Property hasOutgoingConnection = new BpmoProperty(
			"hasOutgoingConnection", null);

	static BpmoConcept Process = new BpmoConcept("Process", new ArrayList() {
		{
			add(hasDescription);
			add(hasName);
		}
	}, new ArrayList() {
		{
			add("Process");
		}
	}, new ArrayList() {
		{
			add("Process");
		}
	});
	static BpmoConcept IntermediateEvent = new BpmoConcept("IntermediateEvent",
			new ArrayList() {
				{
					add(hasDescription);
					add(hasName);
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("Event");
				}
			}, new ArrayList() {
				{
					add("IntermediateEvent");
					add("IntermediateSignalEventCatching");
					add("IntermediateMessageEventCatching");
				}
			});// "IntermediateEvent";
	static BpmoConcept StartEvent = new BpmoConcept("StartEvent",
			new ArrayList() {
				{
					add(hasDescription);
					add(hasName);
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("StartEvent");
					add("StartMessageEvent");
				}
			}, new ArrayList() {
				{
					add("StartEvent");
					add("StartMessageEvent");
				}
			});//
	static BpmoConcept EndEvent = new BpmoConcept("EndEvent", new ArrayList() {
		{
			add(hasDescription);
			add(hasName);
			add(hasHomeProcess);
		}
	}, new ArrayList() {
		{
			add("EndEvent");
			add("EndNoneEvent");
		}
	}, new ArrayList() {
		{
			add("EndEvent");
			add("EndNoneEvent");
		}
	});
	static BpmoConcept Task = new BpmoConcept("Task", new ArrayList() {
		{
			add(hasDescription);
			add(hasName);
			add(hasHomeProcess);
		}
	}, new ArrayList() {
		{
			add("Function");
		}
	}, new ArrayList() {
		{
			add("Task");
			add("AbstractTask");
			add("ManualTask");
			add("ScriptTask");
			add("UserTask");
			add("CompensationActivity");
		}
	});// "Task";
	static BpmoConcept WebServiceTask = new BpmoConcept("WebServiceTask",
			new ArrayList() {
				{
					add(hasDescription);
					add(hasName);
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("ServiceTask");
				}
			}, new ArrayList() {
				{
					add("ServiceTask");
				}
			});
	static BpmoConcept ParallelSplit = new BpmoConcept("ParallelSplit",
			new ArrayList() {
				{
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("AndConnector");
				}
			}, new ArrayList() {
				{
					add("ParallelGateway");
				}
			});
	static BpmoConcept Synchronisation = new BpmoConcept("Synchronisation",
			new ArrayList() {
				{
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("AndConnector");
				}
			}, new ArrayList() {
				{
					add("ParallelGateway");
				}
			});
	static BpmoConcept ExclusiveChoice = new BpmoConcept("ExclusiveChoice",
			new ArrayList() {
				{
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("XorConnector");
				}
			}, new ArrayList() {
				{
					add("ExclusiveGateway");
				}
			});
	static BpmoConcept SimpleMerge = new BpmoConcept("SimpleMerge",
			new ArrayList() {
				{
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("XorConnector");
				}
			}, new ArrayList() {
				{
					add("ExclusiveGateway");
				}
			});
	static BpmoConcept MultipleChoice = new BpmoConcept("MultipleChoice",
			new ArrayList() {
				{
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("OrConnector");
				}
			}, new ArrayList() {
				{
					add("InclusiveGateway");
				}
			});
	static BpmoConcept MultipleMergeSynchronise = new BpmoConcept(
			"MultipleMergeSynchronise", new ArrayList() {
				{
					add(hasHomeProcess);
				}
			}, new ArrayList() {
				{
					add("OrConnector");
				}
			}, new ArrayList() {
				{
					add("InclusiveGateway");
				}
			});
	static BpmoConcept ControlFlowConnector = new BpmoConcept(
			"ControlFlowConnector", new ArrayList() {
				{
					add(hasHomeProcess);
					add(hasTarget);
					add(hasSource);
				}
			}, new ArrayList() {
				{
					add("ControlFlow");
				}
			}, new ArrayList() {
				{
					add("SequenceFlow");
				}
			});

	public static ArrayList<BpmoConcept> listeBpmoElement = new ArrayList() {
		{
			add(Process);
			add(IntermediateEvent);
			add(StartEvent);
			add(EndEvent);
			add(Task);
			add(WebServiceTask);
			add(ParallelSplit);
			add(Synchronisation);
			add(ExclusiveChoice);
			add(SimpleMerge);
			add(MultipleChoice);
			add(MultipleMergeSynchronise);
			add(ControlFlowConnector);
		}
	};
}
